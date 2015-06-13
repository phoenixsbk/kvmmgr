package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class QuotaSelectionChangeEvent extends GwtEvent<QuotaSelectionChangeEvent.QuotaSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.Quota> selectedItems;

  protected QuotaSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public QuotaSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.Quota> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.Quota> selectedItems) {
    QuotaSelectionChangeEvent eventInstance = new QuotaSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, QuotaSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasQuotaSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addQuotaSelectionChangeHandler(QuotaSelectionChangeHandler handler);
  }

  public interface QuotaSelectionChangeHandler extends EventHandler {
    public void onQuotaSelectionChange(QuotaSelectionChangeEvent event);
  }

  private static final Type<QuotaSelectionChangeHandler> TYPE = new Type<QuotaSelectionChangeHandler>();

  public static Type<QuotaSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<QuotaSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(QuotaSelectionChangeHandler handler) {
    handler.onQuotaSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.Quota> getSelectedItems(){
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
    QuotaSelectionChangeEvent other = (QuotaSelectionChangeEvent) obj;
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
    return "QuotaSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
