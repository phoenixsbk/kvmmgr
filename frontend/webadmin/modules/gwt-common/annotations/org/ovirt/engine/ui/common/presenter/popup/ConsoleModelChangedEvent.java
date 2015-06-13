package org.ovirt.engine.ui.common.presenter.popup;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class ConsoleModelChangedEvent extends GwtEvent<ConsoleModelChangedEvent.ConsoleModelChangedHandler> { 


  public ConsoleModelChangedEvent() {
    // Possibly for serialization.
  }

  public static void fire(HasHandlers source) {
    ConsoleModelChangedEvent eventInstance = new ConsoleModelChangedEvent();
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, ConsoleModelChangedEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasConsoleModelChangedHandlers extends HasHandlers {
    HandlerRegistration addConsoleModelChangedHandler(ConsoleModelChangedHandler handler);
  }

  public interface ConsoleModelChangedHandler extends EventHandler {
    public void onConsoleModelChanged(ConsoleModelChangedEvent event);
  }

  private static final Type<ConsoleModelChangedHandler> TYPE = new Type<ConsoleModelChangedHandler>();

  public static Type<ConsoleModelChangedHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<ConsoleModelChangedHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ConsoleModelChangedHandler handler) {
    handler.onConsoleModelChanged(this);
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
    return "ConsoleModelChangedEvent["
    + "]";
  }
}
