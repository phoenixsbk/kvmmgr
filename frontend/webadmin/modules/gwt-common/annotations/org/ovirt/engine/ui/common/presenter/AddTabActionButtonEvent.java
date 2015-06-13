package org.ovirt.engine.ui.common.presenter;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class AddTabActionButtonEvent extends GwtEvent<AddTabActionButtonEvent.AddTabActionButtonHandler> { 

  java.lang.String historyToken;
  org.ovirt.engine.ui.common.widget.action.ActionButtonDefinition<?> buttonDefinition;

  protected AddTabActionButtonEvent() {
    // Possibly for serialization.
  }

  public AddTabActionButtonEvent(java.lang.String historyToken, org.ovirt.engine.ui.common.widget.action.ActionButtonDefinition<?> buttonDefinition) {
    this.historyToken = historyToken;
    this.buttonDefinition = buttonDefinition;
  }

  public static void fire(HasHandlers source, java.lang.String historyToken, org.ovirt.engine.ui.common.widget.action.ActionButtonDefinition<?> buttonDefinition) {
    AddTabActionButtonEvent eventInstance = new AddTabActionButtonEvent(historyToken, buttonDefinition);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, AddTabActionButtonEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasAddTabActionButtonHandlers extends HasHandlers {
    HandlerRegistration addAddTabActionButtonHandler(AddTabActionButtonHandler handler);
  }

  public interface AddTabActionButtonHandler extends EventHandler {
    public void onAddTabActionButton(AddTabActionButtonEvent event);
  }

  private static final Type<AddTabActionButtonHandler> TYPE = new Type<AddTabActionButtonHandler>();

  public static Type<AddTabActionButtonHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<AddTabActionButtonHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(AddTabActionButtonHandler handler) {
    handler.onAddTabActionButton(this);
  }

  public java.lang.String getHistoryToken(){
    return historyToken;
  }

  public org.ovirt.engine.ui.common.widget.action.ActionButtonDefinition<?> getButtonDefinition(){
    return buttonDefinition;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    AddTabActionButtonEvent other = (AddTabActionButtonEvent) obj;
    if (historyToken == null) {
      if (other.historyToken != null)
        return false;
    } else if (!historyToken.equals(other.historyToken))
      return false;
    if (buttonDefinition == null) {
      if (other.buttonDefinition != null)
        return false;
    } else if (!buttonDefinition.equals(other.buttonDefinition))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (historyToken == null ? 1 : historyToken.hashCode());
    hashCode = (hashCode * 37) + (buttonDefinition == null ? 1 : buttonDefinition.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "AddTabActionButtonEvent["
                 + historyToken
                 + ","
                 + buttonDefinition
    + "]";
  }
}
