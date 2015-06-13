package org.ovirt.engine.ui.userportal.uicommon.model;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class UserPortalModelInitEvent extends GwtEvent<UserPortalModelInitEvent.UserPortalModelInitHandler> { 


  public UserPortalModelInitEvent() {
    // Possibly for serialization.
  }

  public static void fire(HasHandlers source) {
    UserPortalModelInitEvent eventInstance = new UserPortalModelInitEvent();
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, UserPortalModelInitEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasUserPortalModelInitHandlers extends HasHandlers {
    HandlerRegistration addUserPortalModelInitHandler(UserPortalModelInitHandler handler);
  }

  public interface UserPortalModelInitHandler extends EventHandler {
    public void onUserPortalModelInit(UserPortalModelInitEvent event);
  }

  private static final Type<UserPortalModelInitHandler> TYPE = new Type<UserPortalModelInitHandler>();

  public static Type<UserPortalModelInitHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<UserPortalModelInitHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(UserPortalModelInitHandler handler) {
    handler.onUserPortalModelInit(this);
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
    return "UserPortalModelInitEvent["
    + "]";
  }
}
