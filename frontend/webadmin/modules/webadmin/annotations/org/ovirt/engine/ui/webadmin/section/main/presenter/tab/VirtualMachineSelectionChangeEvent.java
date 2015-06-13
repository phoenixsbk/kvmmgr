package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class VirtualMachineSelectionChangeEvent extends GwtEvent<VirtualMachineSelectionChangeEvent.VirtualMachineSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.VM> selectedItems;

  protected VirtualMachineSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public VirtualMachineSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.VM> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.VM> selectedItems) {
    VirtualMachineSelectionChangeEvent eventInstance = new VirtualMachineSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, VirtualMachineSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasVirtualMachineSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addVirtualMachineSelectionChangeHandler(VirtualMachineSelectionChangeHandler handler);
  }

  public interface VirtualMachineSelectionChangeHandler extends EventHandler {
    public void onVirtualMachineSelectionChange(VirtualMachineSelectionChangeEvent event);
  }

  private static final Type<VirtualMachineSelectionChangeHandler> TYPE = new Type<VirtualMachineSelectionChangeHandler>();

  public static Type<VirtualMachineSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<VirtualMachineSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(VirtualMachineSelectionChangeHandler handler) {
    handler.onVirtualMachineSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.VM> getSelectedItems(){
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
    VirtualMachineSelectionChangeEvent other = (VirtualMachineSelectionChangeEvent) obj;
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
    return "VirtualMachineSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
