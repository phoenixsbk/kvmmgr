package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class DataCenterSelectionChangeEvent extends GwtEvent<DataCenterSelectionChangeEvent.DataCenterSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.StoragePool> selectedItems;

  protected DataCenterSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public DataCenterSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.StoragePool> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.StoragePool> selectedItems) {
    DataCenterSelectionChangeEvent eventInstance = new DataCenterSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, DataCenterSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasDataCenterSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addDataCenterSelectionChangeHandler(DataCenterSelectionChangeHandler handler);
  }

  public interface DataCenterSelectionChangeHandler extends EventHandler {
    public void onDataCenterSelectionChange(DataCenterSelectionChangeEvent event);
  }

  private static final Type<DataCenterSelectionChangeHandler> TYPE = new Type<DataCenterSelectionChangeHandler>();

  public static Type<DataCenterSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<DataCenterSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(DataCenterSelectionChangeHandler handler) {
    handler.onDataCenterSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.StoragePool> getSelectedItems(){
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
    DataCenterSelectionChangeEvent other = (DataCenterSelectionChangeEvent) obj;
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
    return "DataCenterSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
