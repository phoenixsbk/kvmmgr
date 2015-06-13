package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class VnicProfileSelectionChangeEvent extends GwtEvent<VnicProfileSelectionChangeEvent.VnicProfileSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.network.VnicProfileView> selectedItems;

  protected VnicProfileSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public VnicProfileSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.network.VnicProfileView> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.network.VnicProfileView> selectedItems) {
    VnicProfileSelectionChangeEvent eventInstance = new VnicProfileSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, VnicProfileSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasVnicProfileSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addVnicProfileSelectionChangeHandler(VnicProfileSelectionChangeHandler handler);
  }

  public interface VnicProfileSelectionChangeHandler extends EventHandler {
    public void onVnicProfileSelectionChange(VnicProfileSelectionChangeEvent event);
  }

  private static final Type<VnicProfileSelectionChangeHandler> TYPE = new Type<VnicProfileSelectionChangeHandler>();

  public static Type<VnicProfileSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<VnicProfileSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(VnicProfileSelectionChangeHandler handler) {
    handler.onVnicProfileSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.network.VnicProfileView> getSelectedItems(){
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
    VnicProfileSelectionChangeEvent other = (VnicProfileSelectionChangeEvent) obj;
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
    return "VnicProfileSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
