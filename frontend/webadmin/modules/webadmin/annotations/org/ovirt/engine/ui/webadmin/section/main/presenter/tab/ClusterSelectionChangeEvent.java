package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class ClusterSelectionChangeEvent extends GwtEvent<ClusterSelectionChangeEvent.ClusterSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.VDSGroup> selectedItems;

  protected ClusterSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public ClusterSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.VDSGroup> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.VDSGroup> selectedItems) {
    ClusterSelectionChangeEvent eventInstance = new ClusterSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, ClusterSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasClusterSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addClusterSelectionChangeHandler(ClusterSelectionChangeHandler handler);
  }

  public interface ClusterSelectionChangeHandler extends EventHandler {
    public void onClusterSelectionChange(ClusterSelectionChangeEvent event);
  }

  private static final Type<ClusterSelectionChangeHandler> TYPE = new Type<ClusterSelectionChangeHandler>();

  public static Type<ClusterSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<ClusterSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ClusterSelectionChangeHandler handler) {
    handler.onClusterSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.VDSGroup> getSelectedItems(){
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
    ClusterSelectionChangeEvent other = (ClusterSelectionChangeEvent) obj;
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
    return "ClusterSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
