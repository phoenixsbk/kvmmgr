package org.ovirt.engine.ui.frontend.communication;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class RefreshActiveModelEvent extends GwtEvent<RefreshActiveModelEvent.RefreshActiveModelHandler> { 

  boolean doFastForward;

  protected RefreshActiveModelEvent() {
    // Possibly for serialization.
  }

  public RefreshActiveModelEvent(boolean doFastForward) {
    this.doFastForward = doFastForward;
  }

  public static void fire(HasHandlers source, boolean doFastForward) {
    RefreshActiveModelEvent eventInstance = new RefreshActiveModelEvent(doFastForward);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, RefreshActiveModelEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasRefreshActiveModelHandlers extends HasHandlers {
    HandlerRegistration addRefreshActiveModelHandler(RefreshActiveModelHandler handler);
  }

  public interface RefreshActiveModelHandler extends EventHandler {
    public void onRefreshActiveModel(RefreshActiveModelEvent event);
  }

  private static final Type<RefreshActiveModelHandler> TYPE = new Type<RefreshActiveModelHandler>();

  public static Type<RefreshActiveModelHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<RefreshActiveModelHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(RefreshActiveModelHandler handler) {
    handler.onRefreshActiveModel(this);
  }

  public boolean isDoFastForward(){
    return doFastForward;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    RefreshActiveModelEvent other = (RefreshActiveModelEvent) obj;
    if (doFastForward != other.doFastForward)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + new Boolean(doFastForward).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "RefreshActiveModelEvent["
                 + doFastForward
    + "]";
  }
}
