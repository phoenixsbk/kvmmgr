package org.ovirt.engine.ui.common.presenter;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class RedrawDynamicTabContainerEvent extends GwtEvent<RedrawDynamicTabContainerEvent.RedrawDynamicTabContainerHandler> { 

  com.google.gwt.event.shared.GwtEvent.Type<com.gwtplatform.mvp.client.RequestTabsHandler> requestTabsEventType;

  protected RedrawDynamicTabContainerEvent() {
    // Possibly for serialization.
  }

  public RedrawDynamicTabContainerEvent(com.google.gwt.event.shared.GwtEvent.Type<com.gwtplatform.mvp.client.RequestTabsHandler> requestTabsEventType) {
    this.requestTabsEventType = requestTabsEventType;
  }

  public static void fire(HasHandlers source, com.google.gwt.event.shared.GwtEvent.Type<com.gwtplatform.mvp.client.RequestTabsHandler> requestTabsEventType) {
    RedrawDynamicTabContainerEvent eventInstance = new RedrawDynamicTabContainerEvent(requestTabsEventType);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, RedrawDynamicTabContainerEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasRedrawDynamicTabContainerHandlers extends HasHandlers {
    HandlerRegistration addRedrawDynamicTabContainerHandler(RedrawDynamicTabContainerHandler handler);
  }

  public interface RedrawDynamicTabContainerHandler extends EventHandler {
    public void onRedrawDynamicTabContainer(RedrawDynamicTabContainerEvent event);
  }

  private static final Type<RedrawDynamicTabContainerHandler> TYPE = new Type<RedrawDynamicTabContainerHandler>();

  public static Type<RedrawDynamicTabContainerHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<RedrawDynamicTabContainerHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(RedrawDynamicTabContainerHandler handler) {
    handler.onRedrawDynamicTabContainer(this);
  }

  public com.google.gwt.event.shared.GwtEvent.Type<com.gwtplatform.mvp.client.RequestTabsHandler> getRequestTabsEventType(){
    return requestTabsEventType;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    RedrawDynamicTabContainerEvent other = (RedrawDynamicTabContainerEvent) obj;
    if (requestTabsEventType == null) {
      if (other.requestTabsEventType != null)
        return false;
    } else if (!requestTabsEventType.equals(other.requestTabsEventType))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (requestTabsEventType == null ? 1 : requestTabsEventType.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "RedrawDynamicTabContainerEvent["
                 + requestTabsEventType
    + "]";
  }
}
