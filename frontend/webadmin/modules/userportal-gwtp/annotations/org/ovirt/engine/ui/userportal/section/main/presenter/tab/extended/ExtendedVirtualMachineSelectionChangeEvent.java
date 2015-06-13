package org.ovirt.engine.ui.userportal.section.main.presenter.tab.extended;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class ExtendedVirtualMachineSelectionChangeEvent extends GwtEvent<ExtendedVirtualMachineSelectionChangeEvent.ExtendedVirtualMachineSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.ui.uicommonweb.models.userportal.UserPortalItemModel> selectedItems;

  protected ExtendedVirtualMachineSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public ExtendedVirtualMachineSelectionChangeEvent(java.util.List<org.ovirt.engine.ui.uicommonweb.models.userportal.UserPortalItemModel> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.ui.uicommonweb.models.userportal.UserPortalItemModel> selectedItems) {
    ExtendedVirtualMachineSelectionChangeEvent eventInstance = new ExtendedVirtualMachineSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, ExtendedVirtualMachineSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasExtendedVirtualMachineSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addExtendedVirtualMachineSelectionChangeHandler(ExtendedVirtualMachineSelectionChangeHandler handler);
  }

  public interface ExtendedVirtualMachineSelectionChangeHandler extends EventHandler {
    public void onExtendedVirtualMachineSelectionChange(ExtendedVirtualMachineSelectionChangeEvent event);
  }

  private static final Type<ExtendedVirtualMachineSelectionChangeHandler> TYPE = new Type<ExtendedVirtualMachineSelectionChangeHandler>();

  public static Type<ExtendedVirtualMachineSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<ExtendedVirtualMachineSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ExtendedVirtualMachineSelectionChangeHandler handler) {
    handler.onExtendedVirtualMachineSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.ui.uicommonweb.models.userportal.UserPortalItemModel> getSelectedItems(){
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
    ExtendedVirtualMachineSelectionChangeEvent other = (ExtendedVirtualMachineSelectionChangeEvent) obj;
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
    return "ExtendedVirtualMachineSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
