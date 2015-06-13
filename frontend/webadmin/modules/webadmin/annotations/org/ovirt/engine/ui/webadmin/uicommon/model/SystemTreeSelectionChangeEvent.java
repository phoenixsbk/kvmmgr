package org.ovirt.engine.ui.webadmin.uicommon.model;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class SystemTreeSelectionChangeEvent extends GwtEvent<SystemTreeSelectionChangeEvent.SystemTreeSelectionChangeHandler> { 

  org.ovirt.engine.ui.uicommonweb.models.SystemTreeItemModel selectedItem;

  protected SystemTreeSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public SystemTreeSelectionChangeEvent(org.ovirt.engine.ui.uicommonweb.models.SystemTreeItemModel selectedItem) {
    this.selectedItem = selectedItem;
  }

  public static void fire(HasHandlers source, org.ovirt.engine.ui.uicommonweb.models.SystemTreeItemModel selectedItem) {
    SystemTreeSelectionChangeEvent eventInstance = new SystemTreeSelectionChangeEvent(selectedItem);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, SystemTreeSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasSystemTreeSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addSystemTreeSelectionChangeHandler(SystemTreeSelectionChangeHandler handler);
  }

  public interface SystemTreeSelectionChangeHandler extends EventHandler {
    public void onSystemTreeSelectionChange(SystemTreeSelectionChangeEvent event);
  }

  private static final Type<SystemTreeSelectionChangeHandler> TYPE = new Type<SystemTreeSelectionChangeHandler>();

  public static Type<SystemTreeSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<SystemTreeSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(SystemTreeSelectionChangeHandler handler) {
    handler.onSystemTreeSelectionChange(this);
  }

  public org.ovirt.engine.ui.uicommonweb.models.SystemTreeItemModel getSelectedItem(){
    return selectedItem;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    SystemTreeSelectionChangeEvent other = (SystemTreeSelectionChangeEvent) obj;
    if (selectedItem == null) {
      if (other.selectedItem != null)
        return false;
    } else if (!selectedItem.equals(other.selectedItem))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (selectedItem == null ? 1 : selectedItem.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "SystemTreeSelectionChangeEvent["
                 + selectedItem
    + "]";
  }
}
