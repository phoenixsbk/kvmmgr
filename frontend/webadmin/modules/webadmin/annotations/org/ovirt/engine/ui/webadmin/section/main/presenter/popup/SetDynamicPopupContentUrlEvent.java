package org.ovirt.engine.ui.webadmin.section.main.presenter.popup;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class SetDynamicPopupContentUrlEvent extends GwtEvent<SetDynamicPopupContentUrlEvent.SetDynamicPopupContentUrlHandler> { 

  java.lang.String dialogToken;
  java.lang.String contentUrl;

  protected SetDynamicPopupContentUrlEvent() {
    // Possibly for serialization.
  }

  public SetDynamicPopupContentUrlEvent(java.lang.String dialogToken, java.lang.String contentUrl) {
    this.dialogToken = dialogToken;
    this.contentUrl = contentUrl;
  }

  public static void fire(HasHandlers source, java.lang.String dialogToken, java.lang.String contentUrl) {
    SetDynamicPopupContentUrlEvent eventInstance = new SetDynamicPopupContentUrlEvent(dialogToken, contentUrl);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, SetDynamicPopupContentUrlEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasSetDynamicPopupContentUrlHandlers extends HasHandlers {
    HandlerRegistration addSetDynamicPopupContentUrlHandler(SetDynamicPopupContentUrlHandler handler);
  }

  public interface SetDynamicPopupContentUrlHandler extends EventHandler {
    public void onSetDynamicPopupContentUrl(SetDynamicPopupContentUrlEvent event);
  }

  private static final Type<SetDynamicPopupContentUrlHandler> TYPE = new Type<SetDynamicPopupContentUrlHandler>();

  public static Type<SetDynamicPopupContentUrlHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<SetDynamicPopupContentUrlHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(SetDynamicPopupContentUrlHandler handler) {
    handler.onSetDynamicPopupContentUrl(this);
  }

  public java.lang.String getDialogToken(){
    return dialogToken;
  }

  public java.lang.String getContentUrl(){
    return contentUrl;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    SetDynamicPopupContentUrlEvent other = (SetDynamicPopupContentUrlEvent) obj;
    if (dialogToken == null) {
      if (other.dialogToken != null)
        return false;
    } else if (!dialogToken.equals(other.dialogToken))
      return false;
    if (contentUrl == null) {
      if (other.contentUrl != null)
        return false;
    } else if (!contentUrl.equals(other.contentUrl))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (dialogToken == null ? 1 : dialogToken.hashCode());
    hashCode = (hashCode * 37) + (contentUrl == null ? 1 : contentUrl.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "SetDynamicPopupContentUrlEvent["
                 + dialogToken
                 + ","
                 + contentUrl
    + "]";
  }
}
