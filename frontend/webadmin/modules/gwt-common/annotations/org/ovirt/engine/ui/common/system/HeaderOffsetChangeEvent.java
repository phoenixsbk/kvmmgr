package org.ovirt.engine.ui.common.system;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class HeaderOffsetChangeEvent extends GwtEvent<HeaderOffsetChangeEvent.HeaderOffsetChangeHandler> { 

  int width;

  protected HeaderOffsetChangeEvent() {
    // Possibly for serialization.
  }

  public HeaderOffsetChangeEvent(int width) {
    this.width = width;
  }

  public static void fire(HasHandlers source, int width) {
    HeaderOffsetChangeEvent eventInstance = new HeaderOffsetChangeEvent(width);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, HeaderOffsetChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasHeaderOffsetChangeHandlers extends HasHandlers {
    HandlerRegistration addHeaderOffsetChangeHandler(HeaderOffsetChangeHandler handler);
  }

  public interface HeaderOffsetChangeHandler extends EventHandler {
    public void onHeaderOffsetChange(HeaderOffsetChangeEvent event);
  }

  private static final Type<HeaderOffsetChangeHandler> TYPE = new Type<HeaderOffsetChangeHandler>();

  public static Type<HeaderOffsetChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<HeaderOffsetChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(HeaderOffsetChangeHandler handler) {
    handler.onHeaderOffsetChange(this);
  }

  public int getWidth(){
    return width;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    HeaderOffsetChangeEvent other = (HeaderOffsetChangeEvent) obj;
    if (width != other.width)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + new Integer(width).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "HeaderOffsetChangeEvent["
                 + width
    + "]";
  }
}
