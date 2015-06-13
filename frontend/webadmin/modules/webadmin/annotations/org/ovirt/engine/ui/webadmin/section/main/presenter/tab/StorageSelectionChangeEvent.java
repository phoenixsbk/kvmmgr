package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class StorageSelectionChangeEvent extends GwtEvent<StorageSelectionChangeEvent.StorageSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.StorageDomain> selectedItems;

  protected StorageSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public StorageSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.StorageDomain> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.StorageDomain> selectedItems) {
    StorageSelectionChangeEvent eventInstance = new StorageSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, StorageSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasStorageSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addStorageSelectionChangeHandler(StorageSelectionChangeHandler handler);
  }

  public interface StorageSelectionChangeHandler extends EventHandler {
    public void onStorageSelectionChange(StorageSelectionChangeEvent event);
  }

  private static final Type<StorageSelectionChangeHandler> TYPE = new Type<StorageSelectionChangeHandler>();

  public static Type<StorageSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<StorageSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(StorageSelectionChangeHandler handler) {
    handler.onStorageSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.StorageDomain> getSelectedItems(){
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
    StorageSelectionChangeEvent other = (StorageSelectionChangeEvent) obj;
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
    return "StorageSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
