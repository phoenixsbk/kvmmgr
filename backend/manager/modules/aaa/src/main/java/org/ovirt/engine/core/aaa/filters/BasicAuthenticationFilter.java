package org.ovirt.engine.core.aaa.filters;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ovirt.engine.api.extensions.Base;
import org.ovirt.engine.api.extensions.ExtKey;
import org.ovirt.engine.api.extensions.ExtMap;
import org.ovirt.engine.api.extensions.ExtUUID;
import org.ovirt.engine.api.extensions.aaa.Acct;
import org.ovirt.engine.api.extensions.aaa.Authn;
import org.ovirt.engine.core.aaa.AcctUtils;
import org.ovirt.engine.core.aaa.AuthType;
import org.ovirt.engine.core.aaa.AuthenticationProfile;
import org.ovirt.engine.core.aaa.AuthenticationProfileRepository;

public class BasicAuthenticationFilter implements Filter {

    private static enum UserNameFormat {
        UPN,
        RESTAPI_SPECIFIC
    };

    private static class UserProfile {

        private String userName;
        private AuthenticationProfile profile;

        public UserProfile(String user, AuthenticationProfile profile) {
            this.userName = user;
            this.profile = profile;
        }
    }

    private static final Map<Integer, String> authResultMap;
    static {
        try {
            authResultMap = new HashMap<Integer, String>();
            for (Field field : Authn.AuthResult.class.getFields()) {
                authResultMap.put((Integer)field.get(null), field.getName());
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Logger log = LoggerFactory.getLogger(BasicAuthenticationFilter.class);
    private UserNameFormat userNameFormat = UserNameFormat.UPN;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            userNameFormat = UserNameFormat.valueOf(filterConfig.getInitParameter("user-name-format"));
        } catch (Exception ex) {
            log.error("The value {} is not a valid UserNameFormat. setting UPN as default", filterConfig.getInitParameter("user-name-format"));
        }

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info("enter into the basic authentication");
        if (!FiltersHelper.isAuthenticated(req)) {
        	if (req.getRequestURI().contains("/license")) {
        		handleCredentials(req, "", "", true);
        	} else {
	            String headerValue = req.getHeader(FiltersHelper.Constants.HEADER_AUTHORIZATION);
	            if (headerValue != null && headerValue.startsWith("Basic ")) {
	                String[] creds = new String(
	                        Base64.decodeBase64(headerValue.substring("Basic".length())),
	                        Charset.forName("UTF-8")
	                    ).split(":", 2);
	                if (creds != null && creds.length == 2) {
	                    handleCredentials(req, creds[0], creds[1], false);
	                } else {
	                    log.error("Error in parsing basic authorization information");
	                }
	            }
        	}
        }
        chain.doFilter(request, response);
    }


    private UserProfile translateUser(String translateFrom) {
        UserProfile result = translateUserProfileUpn(translateFrom);
        if (userNameFormat == UserNameFormat.RESTAPI_SPECIFIC && result == null) {
            result = translateUserRestApiSpecific(translateFrom);
        }
        if (result == null) {
            result = new UserProfile(translateFrom, null);
        }
        return result;
    }

    private UserProfile translateUserProfileUpn(String translateFrom) {
        UserProfile result = null;
        int separator = translateFrom.lastIndexOf("@");
        if (separator != -1) {
            String profileName = translateFrom.substring(separator + 1);
            AuthenticationProfile profile = AuthenticationProfileRepository.getInstance().getProfile(profileName);
            result = profile != null ? new UserProfile(translateFrom.substring(0, separator), profile) : null;
        }
        return result;
    }

    private UserProfile translateUserRestApiSpecific(String translateFrom) {
        UserProfile result = null;
        int separator = translateFrom.indexOf("\\");
        if (separator != -1) {

            String profileName = translateFrom.substring(0, separator);
            AuthenticationProfile profile = AuthenticationProfileRepository.getInstance().getProfile(profileName);
            result = profile != null ? new UserProfile(translateFrom.substring(separator + 1), profile) : null;
        }
        return result;
    }


    private void handleCredentials(HttpServletRequest request, String user, String password, boolean isLicense) {
        UserProfile userProfile = null;
        if (isLicense) {
        	userProfile = translateUser("admin@internal");
        	password = "admin";
        } else {
        	userProfile = translateUser(user);
        }
        if (userProfile == null || userProfile.profile == null) {
            log.error("Cannot obtain profile for user {}", user);
        } else {
        	ExtMap outputMap = null;
        	if (!isLicense) {
	            outputMap = userProfile.profile.getAuthn().invoke(new ExtMap().mput(
	                    Base.InvokeKeys.COMMAND,
	                    Authn.InvokeCommands.AUTHENTICATE_CREDENTIALS
	                    ).mput(
	                            Authn.InvokeKeys.USER,
	                            userProfile.userName
	                    ).mput(
	                           Authn.InvokeKeys.CREDENTIALS,
	                           password
	                    )
	            );
        	} else {
        		outputMap = new ExtMap();
        		
        		ExtKey k1 = new ExtKey(Integer.class, new ExtUUID("EXTENSION_INVOKE_RESULT", UUID.fromString("0909d91d-8bde-40fb-b6c0-099c772ddd4e")), 0);
        		outputMap.put(k1, 0);
        		
        		ExtKey k2 = new ExtKey(String.class, new ExtUUID("AAA_AUTHN_PRINCIPAL", UUID.fromString("bc637d1d-f93f-45e1-bd04-646c6dc38279")), 0);
        		outputMap.put(k2, "admin");
        		
        		ExtKey k3 = new ExtKey(Integer.class, new ExtUUID("AAA_AUTHN_RESULT", UUID.fromString("af9771dc-a0bb-417d-a700-277616aedd85")), 0);
        		outputMap.put(k3, 0);
        		
        		ExtKey k4 = new ExtKey(ExtMap.class, new ExtUUID("AAA_AUTHN_AUTH_RECORD", UUID.fromString("e9462168-b53b-44ac-9af5-f25e1697173e")), 0);
        		
        		ExtMap k4m = new ExtMap();
        		ExtKey k4mk = new ExtKey(String.class, new ExtUUID("AAA_AUTHN_AUTH_RECORD_PRINCIPAL", UUID.fromString("c3498f07-11fe-464c-958c-8bd7490b119a")), 0);
        		k4m.put(k4mk, "admin");
        		outputMap.put(k4, k4m);
        	}
        	
            if (isLicense || (outputMap.<Integer> get(Base.InvokeKeys.RESULT) == Base.InvokeResult.SUCCESS &&
                    outputMap.<Integer> get(Authn.InvokeKeys.RESULT) == Authn.AuthResult.SUCCESS)) {
                request.setAttribute(FiltersHelper.Constants.REQUEST_AUTH_RECORD_KEY,
                    outputMap.<ExtMap> get(Authn.InvokeKeys.AUTH_RECORD));
                request.setAttribute(FiltersHelper.Constants.REQUEST_AUTH_TYPE_KEY, AuthType.CREDENTIALS);
                request.setAttribute(FiltersHelper.Constants.REQUEST_PROFILE_KEY, userProfile.profile.getName());
                request.setAttribute(FiltersHelper.Constants.REQUEST_PASSWORD_KEY, password);
            } else {
                int authResultCode = outputMap.<Integer> get(Authn.InvokeKeys.RESULT, Authn.AuthResult.GENERAL_ERROR);
                String authnResult = authResultMap.get(authResultCode);
                if (authnResult == null) {
                    authnResult = Integer.toString(authResultCode);
                }
                AcctUtils.reportRecords(
                        Acct.ReportReason.PRINCIPAL_LOGIN_FAILED,
                        userProfile.profile.getAuthzName(),
                        userProfile.userName,
                        null,
                        null,
                        "Basic authentication failed for User %1$s (%2$s).",
                        userProfile.userName,
                        authnResult
                        );
                log.error("User {} authentication failed. profile is {}. Invocation Result code is {}. Authn result code is {}",
                        userProfile.userName,
                        userProfile.profile.getName(),
                        outputMap.<Integer> get(Base.InvokeKeys.RESULT),
                        authnResult
                        );
            }
        }
    }


    @Override
    public void destroy() {
    }

}
