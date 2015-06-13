package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class NetworkSelectionChangeEvent extends GwtEvent<NetworkSelectionChangeEvent.NetworkSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.network.NetworkView> selectedItems;

  protected NetworkSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public NetworkSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.network.NetworkView> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.network.NetworkView> selectedItems) {
    NetworkSelectionChangeEvent eventInstance = new NetworkSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, NetworkSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasNetworkSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addNetworkSelectionChangeHandler(NetworkSelectionChangeHandler handler);
  }

  public interface NetworkSelectionChangeHandler extends EventHandler {
    public void onNetworkSelectionChange(NetworkSelectionChangeEvent event);
  }

  private static final Type<NetworkSelectionChangeHandler> TYPE = new Type<NetworkSelectionChangeHandler>();

  public static Type<NetworkSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<NetworkSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(NetworkSelectionChangeHandler handler) {
    handler.onNetworkSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.network.NetworkView> getSelectedItems(){
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
    NetworkSelectionChangeEvent other = (NetworkSelectionChangeEvent) obj;
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
    return "NetworkSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
