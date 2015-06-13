package org.ovirt.engine.ui.userportal.section.main.presenter.tab.extended;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class ExtendedTemplateSelectionChangeEvent extends GwtEvent<ExtendedTemplateSelectionChangeEvent.ExtendedTemplateSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.VmTemplate> selectedItems;

  protected ExtendedTemplateSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public ExtendedTemplateSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.VmTemplate> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.VmTemplate> selectedItems) {
    ExtendedTemplateSelectionChangeEvent eventInstance = new ExtendedTemplateSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, ExtendedTemplateSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasExtendedTemplateSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addExtendedTemplateSelectionChangeHandler(ExtendedTemplateSelectionChangeHandler handler);
  }

  public interface ExtendedTemplateSelectionChangeHandler extends EventHandler {
    public void onExtendedTemplateSelectionChange(ExtendedTemplateSelectionChangeEvent event);
  }

  private static final Type<ExtendedTemplateSelectionChangeHandler> TYPE = new Type<ExtendedTemplateSelectionChangeHandler>();

  public static Type<ExtendedTemplateSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<ExtendedTemplateSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ExtendedTemplateSelectionChangeHandler handler) {
    handler.onExtendedTemplateSelectionChange(this);
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
    ExtendedTemplateSelectionChangeEvent other = (ExtendedTemplateSelectionChangeEvent) obj;
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
    return "ExtendedTemplateSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
