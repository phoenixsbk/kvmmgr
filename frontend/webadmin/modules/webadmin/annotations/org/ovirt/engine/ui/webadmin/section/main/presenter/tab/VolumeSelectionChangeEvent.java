package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class VolumeSelectionChangeEvent extends GwtEvent<VolumeSelectionChangeEvent.VolumeSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.gluster.GlusterVolumeEntity> selectedItems;

  protected VolumeSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public VolumeSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.gluster.GlusterVolumeEntity> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.gluster.GlusterVolumeEntity> selectedItems) {
    VolumeSelectionChangeEvent eventInstance = new VolumeSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, VolumeSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasVolumeSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addVolumeSelectionChangeHandler(VolumeSelectionChangeHandler handler);
  }

  public interface VolumeSelectionChangeHandler extends EventHandler {
    public void onVolumeSelectionChange(VolumeSelectionChangeEvent event);
  }

  private static final Type<VolumeSelectionChangeHandler> TYPE = new Type<VolumeSelectionChangeHandler>();

  public static Type<VolumeSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<VolumeSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(VolumeSelectionChangeHandler handler) {
    handler.onVolumeSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.gluster.GlusterVolumeEntity> getSelectedItems(){
    return selectedItems;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    VolumeSelectionChangeEvent other = (VolumeSelectionChangeEvent) obj;
    if (selectedItems == null) {
      if (other.selectedItems != null)
        return false;
    } else if (!selectedItems.equals(other.selectedItems))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (selectedItems == null ? 1 : selectedItems.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "VolumeSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
