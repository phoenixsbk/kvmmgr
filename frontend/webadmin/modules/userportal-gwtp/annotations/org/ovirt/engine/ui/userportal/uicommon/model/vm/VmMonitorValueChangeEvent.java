package org.ovirt.engine.ui.userportal.uicommon.model.vm;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class VmMonitorValueChangeEvent extends GwtEvent<VmMonitorValueChangeEvent.VmMonitorValueChangeHandler> { 


  public VmMonitorValueChangeEvent() {
    // Possibly for serialization.
  }

  public static void fire(HasHandlers source) {
    VmMonitorValueChangeEvent eventInstance = new VmMonitorValueChangeEvent();
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, VmMonitorValueChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasVmMonitorValueChangeHandlers extends HasHandlers {
    HandlerRegistration addVmMonitorValueChangeHandler(VmMonitorValueChangeHandler handler);
  }

  public interface VmMonitorValueChangeHandler extends EventHandler {
    public void onVmMonitorValueChange(VmMonitorValueChangeEvent event);
  }

  private static final Type<VmMonitorValueChangeHandler> TYPE = new Type<VmMonitorValueChangeHandler>();

  public static Type<VmMonitorValueChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<VmMonitorValueChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(VmMonitorValueChangeHandler handler) {
    handler.onVmMonitorValueChange(this);
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
    return "VmMonitorValueChangeEvent["
    + "]";
  }
}
