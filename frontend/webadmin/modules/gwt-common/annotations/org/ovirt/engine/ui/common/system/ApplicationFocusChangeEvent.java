package org.ovirt.engine.ui.common.system;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class ApplicationFocusChangeEvent extends GwtEvent<ApplicationFocusChangeEvent.ApplicationFocusChangeHandler> { 

  boolean inFocus;

  protected ApplicationFocusChangeEvent() {
    // Possibly for serialization.
  }

  public ApplicationFocusChangeEvent(boolean inFocus) {
    this.inFocus = inFocus;
  }

  public static void fire(HasHandlers source, boolean inFocus) {
    ApplicationFocusChangeEvent eventInstance = new ApplicationFocusChangeEvent(inFocus);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, ApplicationFocusChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasApplicationFocusChangeHandlers extends HasHandlers {
    HandlerRegistration addApplicationFocusChangeHandler(ApplicationFocusChangeHandler handler);
  }

  public interface ApplicationFocusChangeHandler extends EventHandler {
    public void onApplicationFocusChange(ApplicationFocusChangeEvent event);
  }

  private static final Type<ApplicationFocusChangeHandler> TYPE = new Type<ApplicationFocusChangeHandler>();

  public static Type<ApplicationFocusChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<ApplicationFocusChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ApplicationFocusChangeHandler handler) {
    handler.onApplicationFocusChange(this);
  }

  public boolean isInFocus(){
    return inFocus;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    ApplicationFocusChangeEvent other = (ApplicationFocusChangeEvent) obj;
    if (inFocus != other.inFocus)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + new Boolean(inFocus).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "ApplicationFocusChangeEvent["
                 + inFocus
    + "]";
  }
}
