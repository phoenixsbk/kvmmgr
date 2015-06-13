package org.ovirt.engine.ui.webadmin.section.main.presenter;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class SetDynamicTabContentUrlEvent extends GwtEvent<SetDynamicTabContentUrlEvent.SetDynamicTabContentUrlHandler> { 

  java.lang.String historyToken;
  java.lang.String contentUrl;

  protected SetDynamicTabContentUrlEvent() {
    // Possibly for serialization.
  }

  public SetDynamicTabContentUrlEvent(java.lang.String historyToken, java.lang.String contentUrl) {
    this.historyToken = historyToken;
    this.contentUrl = contentUrl;
  }

  public static void fire(HasHandlers source, java.lang.String historyToken, java.lang.String contentUrl) {
    SetDynamicTabContentUrlEvent eventInstance = new SetDynamicTabContentUrlEvent(historyToken, contentUrl);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, SetDynamicTabContentUrlEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasSetDynamicTabContentUrlHandlers extends HasHandlers {
    HandlerRegistration addSetDynamicTabContentUrlHandler(SetDynamicTabContentUrlHandler handler);
  }

  public interface SetDynamicTabContentUrlHandler extends EventHandler {
    public void onSetDynamicTabContentUrl(SetDynamicTabContentUrlEvent event);
  }

  private static final Type<SetDynamicTabContentUrlHandler> TYPE = new Type<SetDynamicTabContentUrlHandler>();

  public static Type<SetDynamicTabContentUrlHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<SetDynamicTabContentUrlHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(SetDynamicTabContentUrlHandler handler) {
    handler.onSetDynamicTabContentUrl(this);
  }

  public java.lang.String getHistoryToken(){
    return historyToken;
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
    SetDynamicTabContentUrlEvent other = (SetDynamicTabContentUrlEvent) obj;
    if (historyToken == null) {
      if (other.historyToken != null)
        return false;
    } else if (!historyToken.equals(other.historyToken))
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
    hashCode = (hashCode * 37) + (historyToken == null ? 1 : historyToken.hashCode());
    hashCode = (hashCode * 37) + (contentUrl == null ? 1 : contentUrl.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "SetDynamicTabContentUrlEvent["
                 + historyToken
                 + ","
                 + contentUrl
    + "]";
  }
}
