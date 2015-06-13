package org.ovirt.engine.ui.webadmin.system;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class MessageReceivedEvent extends GwtEvent<MessageReceivedEvent.MessageReceivedHandler> { 

  org.ovirt.engine.ui.webadmin.system.MessageEventData data;

  protected MessageReceivedEvent() {
    // Possibly for serialization.
  }

  public MessageReceivedEvent(org.ovirt.engine.ui.webadmin.system.MessageEventData data) {
    this.data = data;
  }

  public static void fire(HasHandlers source, org.ovirt.engine.ui.webadmin.system.MessageEventData data) {
    MessageReceivedEvent eventInstance = new MessageReceivedEvent(data);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, MessageReceivedEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasMessageReceivedHandlers extends HasHandlers {
    HandlerRegistration addMessageReceivedHandler(MessageReceivedHandler handler);
  }

  public interface MessageReceivedHandler extends EventHandler {
    public void onMessageReceived(MessageReceivedEvent event);
  }

  private static final Type<MessageReceivedHandler> TYPE = new Type<MessageReceivedHandler>();

  public static Type<MessageReceivedHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<MessageReceivedHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(MessageReceivedHandler handler) {
    handler.onMessageReceived(this);
  }

  public org.ovirt.engine.ui.webadmin.system.MessageEventData getData(){
    return data;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    MessageReceivedEvent other = (MessageReceivedEvent) obj;
    if (data == null) {
      if (other.data != null)
        return false;
    } else if (!data.equals(other.data))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (data == null ? 1 : data.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "MessageReceivedEvent["
                 + data
    + "]";
  }
}
