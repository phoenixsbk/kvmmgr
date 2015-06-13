package org.ovirt.engine.ui.frontend.communication;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class EngineSessionRefreshedEvent extends GwtEvent<EngineSessionRefreshedEvent.EngineSessionRefreshedHandler> { 


  public EngineSessionRefreshedEvent() {
    // Possibly for serialization.
  }

  public static void fire(HasHandlers source) {
    EngineSessionRefreshedEvent eventInstance = new EngineSessionRefreshedEvent();
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, EngineSessionRefreshedEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasEngineSessionRefreshedHandlers extends HasHandlers {
    HandlerRegistration addEngineSessionRefreshedHandler(EngineSessionRefreshedHandler handler);
  }

  public interface EngineSessionRefreshedHandler extends EventHandler {
    public void onEngineSessionRefreshed(EngineSessionRefreshedEvent event);
  }

  private static final Type<EngineSessionRefreshedHandler> TYPE = new Type<EngineSessionRefreshedHandler>();

  public static Type<EngineSessionRefreshedHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<EngineSessionRefreshedHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(EngineSessionRefreshedHandler handler) {
    handler.onEngineSessionRefreshed(this);
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
    return "EngineSessionRefreshedEvent["
    + "]";
  }
}
