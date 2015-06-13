package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class TemplateSelectionChangeEvent extends GwtEvent<TemplateSelectionChangeEvent.TemplateSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.VmTemplate> selectedItems;

  protected TemplateSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public TemplateSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.VmTemplate> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.VmTemplate> selectedItems) {
    TemplateSelectionChangeEvent eventInstance = new TemplateSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, TemplateSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasTemplateSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addTemplateSelectionChangeHandler(TemplateSelectionChangeHandler handler);
  }

  public interface TemplateSelectionChangeHandler extends EventHandler {
    public void onTemplateSelectionChange(TemplateSelectionChangeEvent event);
  }

  private static final Type<TemplateSelectionChangeHandler> TYPE = new Type<TemplateSelectionChangeHandler>();

  public static Type<TemplateSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<TemplateSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(TemplateSelectionChangeHandler handler) {
    handler.onTemplateSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.VmTemplate> getSelectedItems(){
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
    TemplateSelectionChangeEvent other = (TemplateSelectionChangeEvent) obj;
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
    return "TemplateSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
