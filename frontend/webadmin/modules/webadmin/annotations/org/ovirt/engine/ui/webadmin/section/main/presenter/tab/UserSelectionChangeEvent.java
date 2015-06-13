package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class UserSelectionChangeEvent extends GwtEvent<UserSelectionChangeEvent.UserSelectionChangeHandler> { 

  java.util.List<org.ovirt.engine.core.common.businessentities.aaa.DbUser> selectedItems;

  protected UserSelectionChangeEvent() {
    // Possibly for serialization.
  }

  public UserSelectionChangeEvent(java.util.List<org.ovirt.engine.core.common.businessentities.aaa.DbUser> selectedItems) {
    this.selectedItems = selectedItems;
  }

  public static void fire(HasHandlers source, java.util.List<org.ovirt.engine.core.common.businessentities.aaa.DbUser> selectedItems) {
    UserSelectionChangeEvent eventInstance = new UserSelectionChangeEvent(selectedItems);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, UserSelectionChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasUserSelectionChangeHandlers extends HasHandlers {
    HandlerRegistration addUserSelectionChangeHandler(UserSelectionChangeHandler handler);
  }

  public interface UserSelectionChangeHandler extends EventHandler {
    public void onUserSelectionChange(UserSelectionChangeEvent event);
  }

  private static final Type<UserSelectionChangeHandler> TYPE = new Type<UserSelectionChangeHandler>();

  public static Type<UserSelectionChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<UserSelectionChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(UserSelectionChangeHandler handler) {
    handler.onUserSelectionChange(this);
  }

  public java.util.List<org.ovirt.engine.core.common.businessentities.aaa.DbUser> getSelectedItems(){
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
    UserSelectionChangeEvent other = (UserSelectionChangeEvent) obj;
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
    return "UserSelectionChangeEvent["
                 + selectedItems
    + "]";
  }
}
