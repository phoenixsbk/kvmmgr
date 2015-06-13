package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class PoolSelectionChangeEvent extends GwtEvent<PoolSelectionChangeEvent.PoolSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.VmPool> selectedItems;

  protected PoolSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public PoolSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.VmPool> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.VmPool> selectedItems) {
    PoolSelectionChangeEvent eventInstance = new PoolSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, PoolSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasPoolSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addPoolSelectionChangeHandler(PoolSelectionChangeHandler handler);
  }

  public interface PoolSelectionChangeHandler extends EventHandler {
    public void onPoolSelectionChange(PoolSelectionChangeEvent event);
  }

  private static final Type<PoolSelectionChangeHandler> TYPE = new Type<PoolSelectionChangeHandler>();

  public static Type<PoolSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<PoolSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(PoolSelectionChangeHandler handler) {
    handler.onPoolSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.VmPool> getSelectedItems(){
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
    PoolSelectionChangeEvent other = (PoolSelectionChangeEvent) obj;
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
    return "PoolSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
