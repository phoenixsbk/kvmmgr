package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class ProviderSelectionChangeEvent extends GwtEvent<ProviderSelectionChangeEvent.ProviderSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.Provider> selectedItems;

  protected ProviderSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public ProviderSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.Provider> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.Provider> selectedItems) {
    ProviderSelectionChangeEvent eventInstance = new ProviderSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, ProviderSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasProviderSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addProviderSelectionChangeHandler(ProviderSelectionChangeHandler handler);
  }

  public interface ProviderSelectionChangeHandler extends EventHandler {
    public void onProviderSelectionChange(ProviderSelectionChangeEvent event);
  }

  private static final Type<ProviderSelectionChangeHandler> TYPE = new Type<ProviderSelectionChangeHandler>();

  public static Type<ProviderSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<ProviderSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ProviderSelectionChangeHandler handler) {
    handler.onProviderSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.Provider> getSelectedItems(){
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
    ProviderSelectionChangeEvent other = (ProviderSelectionChangeEvent) obj;
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
    return "ProviderSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
