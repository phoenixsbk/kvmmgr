package org.ovirt.engine.ui.common.presenter.popup.numa;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class UpdatedVnumaEvent extends GwtEvent<UpdatedVnumaEvent.UpdatedVnumaHandler> { 

  org.ovirt.engine.core.compat.Guid sourceVmGuid;
  boolean pinned;
  int sourceVNumaNodeIndex;
  int targetNumaNodeIndex;

  protected UpdatedVnumaEvent() {
    // Possibly for serialization.
  }

  public UpdatedVnumaEvent(org.ovirt.engine.core.compat.Guid sourceVmGuid, boolean pinned, int sourceVNumaNodeIndex, int targetNumaNodeIndex) {
    this.sourceVmGuid = sourceVmGuid;
    this.pinned = pinned;
    this.sourceVNumaNodeIndex = sourceVNumaNodeIndex;
    this.targetNumaNodeIndex = targetNumaNodeIndex;
  }

  public static void fire(HasHandlers source, org.ovirt.engine.core.compat.Guid sourceVmGuid, boolean pinned, int sourceVNumaNodeIndex, int targetNumaNodeIndex) {
    UpdatedVnumaEvent eventInstance = new UpdatedVnumaEvent(sourceVmGuid, pinned, sourceVNumaNodeIndex, targetNumaNodeIndex);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, UpdatedVnumaEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasUpdatedVnumaHandlers extends HasHandlers {
    HandlerRegistration addUpdatedVnumaHandler(UpdatedVnumaHandler handler);
  }

  public interface UpdatedVnumaHandler extends EventHandler {
    public void onUpdatedVnuma(UpdatedVnumaEvent event);
  }

  private static final Type<UpdatedVnumaHandler> TYPE = new Type<UpdatedVnumaHandler>();

  public static Type<UpdatedVnumaHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<UpdatedVnumaHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(UpdatedVnumaHandler handler) {
    handler.onUpdatedVnuma(this);
  }

  public org.ovirt.engine.core.compat.Guid getSourceVmGuid(){
    return sourceVmGuid;
  }

  public boolean isPinned(){
    return pinned;
  }

  public int getSourceVNumaNodeIndex(){
    return sourceVNumaNodeIndex;
  }

  public int getTargetNumaNodeIndex(){
    return targetNumaNodeIndex;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    UpdatedVnumaEvent other = (UpdatedVnumaEvent) obj;
    if (sourceVmGuid == null) {
      if (other.sourceVmGuid != null)
        return false;
    } else if (!sourceVmGuid.equals(other.sourceVmGuid))
      return false;
    if (pinned != other.pinned)
        return false;
    if (sourceVNumaNodeIndex != other.sourceVNumaNodeIndex)
        return false;
    if (targetNumaNodeIndex != other.targetNumaNodeIndex)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (sourceVmGuid == null ? 1 : sourceVmGuid.hashCode());
    hashCode = (hashCode * 37) + new Boolean(pinned).hashCode();
    hashCode = (hashCode * 37) + new Integer(sourceVNumaNodeIndex).hashCode();
    hashCode = (hashCode * 37) + new Integer(targetNumaNodeIndex).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "UpdatedVnumaEvent["
                 + sourceVmGuid
                 + ","
                 + pinned
                 + ","
                 + sourceVNumaNodeIndex
                 + ","
                 + targetNumaNodeIndex
    + "]";
  }
}
