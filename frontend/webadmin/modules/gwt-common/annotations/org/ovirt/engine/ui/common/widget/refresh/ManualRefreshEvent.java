package org.ovirt.engine.ui.common.widget.refresh;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class ManualRefreshEvent extends GwtEvent<ManualRefreshEvent.ManualRefreshHandler> { 


  public ManualRefreshEvent() {
    // Possibly for serialization.
  }

  public static void fire(HasHandlers source) {
    ManualRefreshEvent eventInstance = new ManualRefreshEvent();
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, ManualRefreshEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasManualRefreshHandlers extends HasHandlers {
    HandlerRegistration addManualRefreshHandler(ManualRefreshHandler handler);
  }

  public interface ManualRefreshHandler extends EventHandler {
    public void onManualRefresh(ManualRefreshEvent event);
  }

  private static final Type<ManualRefreshHandler> TYPE = new Type<ManualRefreshHandler>();

  public static Type<ManualRefreshHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<ManualRefreshHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ManualRefreshHandler handler) {
    handler.onManualRefresh(this);
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
    return "ManualRefreshEvent["
    + "]";
  }
}
