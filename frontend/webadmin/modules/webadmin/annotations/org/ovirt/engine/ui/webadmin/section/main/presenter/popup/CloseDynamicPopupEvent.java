package org.ovirt.engine.ui.webadmin.section.main.presenter.popup;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class CloseDynamicPopupEvent extends GwtEvent<CloseDynamicPopupEvent.CloseDynamicPopupHandler> { 

  java.lang.String dialogToken;

  protected CloseDynamicPopupEvent() {
    // Possibly for serialization.
  }

  public CloseDynamicPopupEvent(java.lang.String dialogToken) {
    this.dialogToken = dialogToken;
  }

  public static void fire(HasHandlers source, java.lang.String dialogToken) {
    CloseDynamicPopupEvent eventInstance = new CloseDynamicPopupEvent(dialogToken);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, CloseDynamicPopupEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasCloseDynamicPopupHandlers extends HasHandlers {
    HandlerRegistration addCloseDynamicPopupHandler(CloseDynamicPopupHandler handler);
  }

  public interface CloseDynamicPopupHandler extends EventHandler {
    public void onCloseDynamicPopup(CloseDynamicPopupEvent event);
  }

  private static final Type<CloseDynamicPopupHandler> TYPE = new Type<CloseDynamicPopupHandler>();

  public static Type<CloseDynamicPopupHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<CloseDynamicPopupHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(CloseDynamicPopupHandler handler) {
    handler.onCloseDynamicPopup(this);
  }

  public java.lang.String getDialogToken(){
    return dialogToken;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    CloseDynamicPopupEvent other = (CloseDynamicPopupEvent) obj;
    if (dialogToken == null) {
      if (other.dialogToken != null)
        return false;
    } else if (!dialogToken.equals(other.dialogToken))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (dialogToken == null ? 1 : dialogToken.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "CloseDynamicPopupEvent["
                 + dialogToken
    + "]";
  }
}
