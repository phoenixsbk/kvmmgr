package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class EventSelectionChangeEvent extends GwtEvent<EventSelectionChangeEvent.EventSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.AuditLog> selectedItems;

  protected EventSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public EventSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.AuditLog> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.AuditLog> selectedItems) {
    EventSelectionChangeEvent eventInstance = new EventSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, EventSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasEventSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addEventSelectionChangeHandler(EventSelectionChangeHandler handler);
  }

  public interface EventSelectionChangeHandler extends EventHandler {
    public void onEventSelectionChange(EventSelectionChangeEvent event);
  }

  private static final Type<EventSelectionChangeHandler> TYPE = new Type<EventSelectionChangeHandler>();

  public static Type<EventSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<EventSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(EventSelectionChangeHandler handler) {
    handler.onEventSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.AuditLog> getSelectedItems(){
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
    EventSelectionChangeEvent other = (EventSelectionChangeEvent) obj;
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
    return "EventSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
