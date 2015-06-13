package org.ovirt.engine.ui.common.presenter;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class SetDynamicTabAccessibleEvent extends GwtEvent<SetDynamicTabAccessibleEvent.SetDynamicTabAccessibleHandler> { 

  java.lang.String historyToken;
  boolean tabAccessible;

  protected SetDynamicTabAccessibleEvent() {
    // Possibly for serialization.
  }

  public SetDynamicTabAccessibleEvent(java.lang.String historyToken, boolean tabAccessible) {
    this.historyToken = historyToken;
    this.tabAccessible = tabAccessible;
  }

  public static void fire(HasHandlers source, java.lang.String historyToken, boolean tabAccessible) {
    SetDynamicTabAccessibleEvent eventInstance = new SetDynamicTabAccessibleEvent(historyToken, tabAccessible);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, SetDynamicTabAccessibleEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasSetDynamicTabAccessibleHandlers extends HasHandlers {
    HandlerRegistration addSetDynamicTabAccessibleHandler(SetDynamicTabAccessibleHandler handler);
  }

  public interface SetDynamicTabAccessibleHandler extends EventHandler {
    public void onSetDynamicTabAccessible(SetDynamicTabAccessibleEvent event);
  }

  private static final Type<SetDynamicTabAccessibleHandler> TYPE = new Type<SetDynamicTabAccessibleHandler>();

  public static Type<SetDynamicTabAccessibleHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<SetDynamicTabAccessibleHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(SetDynamicTabAccessibleHandler handler) {
    handler.onSetDynamicTabAccessible(this);
  }

  public java.lang.String getHistoryToken(){
    return historyToken;
  }

  public boolean isTabAccessible(){
    return tabAccessible;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    SetDynamicTabAccessibleEvent other = (SetDynamicTabAccessibleEvent) obj;
    if (historyToken == null) {
      if (other.historyToken != null)
        return false;
    } else if (!historyToken.equals(other.historyToken))
      return false;
    if (tabAccessible != other.tabAccessible)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (historyToken == null ? 1 : historyToken.hashCode());
    hashCode = (hashCode * 37) + new Boolean(tabAccessible).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "SetDynamicTabAccessibleEvent["
                 + historyToken
                 + ","
                 + tabAccessible
    + "]";
  }
}
