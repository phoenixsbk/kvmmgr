package org.ovirt.engine.ui.frontend.communication;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class SSOTokenChangeEvent extends GwtEvent<SSOTokenChangeEvent.SSOTokenChangeHandler> { 

  java.lang.String token;

  protected SSOTokenChangeEvent() {
    // Possibly for serialization.
  }

  public SSOTokenChangeEvent(java.lang.String token) {
    this.token = token;
  }

  public static void fire(HasHandlers source, java.lang.String token) {
    SSOTokenChangeEvent eventInstance = new SSOTokenChangeEvent(token);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, SSOTokenChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasSSOTokenChangeHandlers extends HasHandlers {
    HandlerRegistration addSSOTokenChangeHandler(SSOTokenChangeHandler handler);
  }

  public interface SSOTokenChangeHandler extends EventHandler {
    public void onSSOTokenChange(SSOTokenChangeEvent event);
  }

  private static final Type<SSOTokenChangeHandler> TYPE = new Type<SSOTokenChangeHandler>();

  public static Type<SSOTokenChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<SSOTokenChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(SSOTokenChangeHandler handler) {
    handler.onSSOTokenChange(this);
  }

  public java.lang.String getToken(){
    return token;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    SSOTokenChangeEvent other = (SSOTokenChangeEvent) obj;
    if (token == null) {
      if (other.token != null)
        return false;
    } else if (!token.equals(other.token))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (token == null ? 1 : token.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "SSOTokenChangeEvent["
                 + token
    + "]";
  }
}
