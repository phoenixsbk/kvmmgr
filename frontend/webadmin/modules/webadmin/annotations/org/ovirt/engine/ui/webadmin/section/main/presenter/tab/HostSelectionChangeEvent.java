package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class HostSelectionChangeEvent extends GwtEvent<HostSelectionChangeEvent.HostSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.VDS> selectedItems;

  protected HostSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public HostSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.VDS> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.VDS> selectedItems) {
    HostSelectionChangeEvent eventInstance = new HostSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, HostSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasHostSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addHostSelectionChangeHandler(HostSelectionChangeHandler handler);
  }

  public interface HostSelectionChangeHandler extends EventHandler {
    public void onHostSelectionChange(HostSelectionChangeEvent event);
  }

  private static final Type<HostSelectionChangeHandler> TYPE = new Type<HostSelectionChangeHandler>();

  public static Type<HostSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<HostSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(HostSelectionChangeHandler handler) {
    handler.onHostSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.VDS> getSelectedItems(){
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
    HostSelectionChangeEvent other = (HostSelectionChangeEvent) obj;
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
    return "HostSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
