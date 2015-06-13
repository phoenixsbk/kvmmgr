package org.ovirt.engine.ui.webadmin.plugin.restapi;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class RestApiSessionAcquiredEvent extends GwtEvent<RestApiSessionAcquiredEvent.RestApiSessionAcquiredHandler> { 

  java.lang.String sessionId;

  protected RestApiSessionAcquiredEvent() {
    // Possibly for serialization.
  }

  public RestApiSessionAcquiredEvent(java.lang.String sessionId) {
    this.sessionId = sessionId;
  }

  public static void fire(HasHandlers source, java.lang.String sessionId) {
    RestApiSessionAcquiredEvent eventInstance = new RestApiSessionAcquiredEvent(sessionId);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, RestApiSessionAcquiredEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasRestApiSessionAcquiredHandlers extends HasHandlers {
    HandlerRegistration addRestApiSessionAcquiredHandler(RestApiSessionAcquiredHandler handler);
  }

  public interface RestApiSessionAcquiredHandler extends EventHandler {
    public void onRestApiSessionAcquired(RestApiSessionAcquiredEvent event);
  }

  private static final Type<RestApiSessionAcquiredHandler> TYPE = new Type<RestApiSessionAcquiredHandler>();

  public static Type<RestApiSessionAcquiredHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<RestApiSessionAcquiredHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(RestApiSessionAcquiredHandler handler) {
    handler.onRestApiSessionAcquired(this);
  }

  public java.lang.String getSessionId(){
    return sessionId;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    RestApiSessionAcquiredEvent other = (RestApiSessionAcquiredEvent) obj;
    if (sessionId == null) {
      if (other.sessionId != null)
        return false;
    } else if (!sessionId.equals(other.sessionId))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (sessionId == null ? 1 : sessionId.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "RestApiSessionAcquiredEvent["
                 + sessionId
    + "]";
  }
}
