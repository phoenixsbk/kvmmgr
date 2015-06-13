package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class DiskSelectionChangeEvent extends GwtEvent<DiskSelectionChangeEvent.DiskSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.Disk> selectedItems;

  protected DiskSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public DiskSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.Disk> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.Disk> selectedItems) {
    DiskSelectionChangeEvent eventInstance = new DiskSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, DiskSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasDiskSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addDiskSelectionChangeHandler(DiskSelectionChangeHandler handler);
  }

  public interface DiskSelectionChangeHandler extends EventHandler {
    public void onDiskSelectionChange(DiskSelectionChangeEvent event);
  }

  private static final Type<DiskSelectionChangeHandler> TYPE = new Type<DiskSelectionChangeHandler>();

  public static Type<DiskSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<DiskSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(DiskSelectionChangeHandler handler) {
    handler.onDiskSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.Disk> getSelectedItems(){
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
    DiskSelectionChangeEvent other = (DiskSelectionChangeEvent) obj;
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
    return "DiskSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
