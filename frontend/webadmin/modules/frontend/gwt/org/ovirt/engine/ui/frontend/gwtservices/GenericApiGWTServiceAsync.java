package org.ovirt.engine.ui.frontend.gwtservices;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface GenericApiGWTServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void runQuery( org.ovirt.engine.core.common.queries.VdcQueryType search, org.ovirt.engine.core.common.queries.VdcQueryParametersBase searchParameters, AsyncCallback<org.ovirt.engine.core.common.queries.VdcQueryReturnValue> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void runAction( org.ovirt.engine.core.common.action.VdcActionType actionType, org.ovirt.engine.core.common.action.VdcActionParametersBase params, AsyncCallback<org.ovirt.engine.core.common.action.VdcReturnValueBase> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void runPublicQuery( org.ovirt.engine.core.common.queries.VdcQueryType queryType, org.ovirt.engine.core.common.queries.VdcQueryParametersBase params, AsyncCallback<org.ovirt.engine.core.common.queries.VdcQueryReturnValue> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void runMultipleQueries( java.util.ArrayList<org.ovirt.engine.core.common.queries.VdcQueryType> vdcQueryTypeList, java.util.ArrayList<org.ovirt.engine.core.common.queries.VdcQueryParametersBase> paramsList, AsyncCallback<java.util.ArrayList<org.ovirt.engine.core.common.queries.VdcQueryReturnValue>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void runMultipleActions( org.ovirt.engine.core.common.action.VdcActionType actionType, java.util.ArrayList<org.ovirt.engine.core.common.action.VdcActionParametersBase> multipleParams, boolean isRunOnlyIfAllCanDoPass, AsyncCallback<java.util.ArrayList<org.ovirt.engine.core.common.action.VdcReturnValueBase>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void runMultipleActions( org.ovirt.engine.core.common.action.VdcActionType actionType, java.util.ArrayList<org.ovirt.engine.core.common.action.VdcActionParametersBase> multipleParams, boolean isRunOnlyIfAllCanDoPass, boolean isWaitForResult, AsyncCallback<java.util.ArrayList<org.ovirt.engine.core.common.action.VdcReturnValueBase>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void getLoggedInUser( AsyncCallback<org.ovirt.engine.core.common.businessentities.aaa.DbUser> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void logOff( org.ovirt.engine.core.common.businessentities.aaa.DbUser userToLogoff, AsyncCallback<org.ovirt.engine.core.common.action.VdcReturnValueBase> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void login( java.lang.String userName, java.lang.String password, java.lang.String profileName, org.ovirt.engine.core.common.action.VdcActionType loginType, AsyncCallback<org.ovirt.engine.core.common.action.VdcReturnValueBase> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void storeInHttpSession( java.lang.String key, java.lang.String value, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.ovirt.engine.ui.frontend.gwtservices.GenericApiGWTService
     */
    void retrieveFromHttpSession( java.lang.String key, AsyncCallback<java.lang.String> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static GenericApiGWTServiceAsync instance;

        public static final GenericApiGWTServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (GenericApiGWTServiceAsync) GWT.create( GenericApiGWTService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
