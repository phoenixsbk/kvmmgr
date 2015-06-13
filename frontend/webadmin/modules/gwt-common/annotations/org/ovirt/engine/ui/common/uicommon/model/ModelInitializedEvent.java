package org.ovirt.engine.ui.common.uicommon.model;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class ModelInitializedEvent extends GwtEvent<ModelInitializedEvent.ModelInitializedHandler> { 


  public ModelInitializedEvent() {
    // Possibly for serialization.
  }

  public static void fire(HasHandlers source) {
    ModelInitializedEvent eventInstance = new ModelInitializedEvent();
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, ModelInitializedEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasModelInitializedHandlers extends HasHandlers {
    HandlerRegistration addModelInitializedHandler(ModelInitializedHandler handler);
  }

  public interface ModelInitializedHandler extends EventHandler {
    public void onModelInitialized(ModelInitializedEvent event);
  }

  private static final Type<ModelInitializedHandler> TYPE = new Type<ModelInitializedHandler>();

  public static Type<ModelInitializedHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<ModelInitializedHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ModelInitializedHandler handler) {
    handler.onModelInitialized(this);
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
    return "ModelInitializedEvent["
    + "]";
  }
}
