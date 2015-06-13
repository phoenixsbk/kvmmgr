package org.ovirt.engine.ui.common.auth;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class UserLoginChangeEvent extends GwtEvent<UserLoginChangeEvent.UserLoginChangeHandler> { 


  public UserLoginChangeEvent() {
    // Possibly for serialization.
  }

  public static void fire(HasHandlers source) {
    UserLoginChangeEvent eventInstance = new UserLoginChangeEvent();
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, UserLoginChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasUserLoginChangeHandlers extends HasHandlers {
    HandlerRegistration addUserLoginChangeHandler(UserLoginChangeHandler handler);
  }

  public interface UserLoginChangeHandler extends EventHandler {
    public void onUserLoginChange(UserLoginChangeEvent event);
  }

  private static final Type<UserLoginChangeHandler> TYPE = new Type<UserLoginChangeHandler>();

  public static Type<UserLoginChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<UserLoginChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(UserLoginChangeHandler handler) {
    handler.onUserLoginChange(this);
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return "UserLoginChangeEvent["
    + "]";
  }
}
