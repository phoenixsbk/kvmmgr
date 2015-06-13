package org.ovirt.engine.ui.webadmin.section.main.presenter;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class UpdateMainContentLayoutEvent extends GwtEvent<UpdateMainContentLayoutEvent.UpdateMainContentLayoutHandler> { 

  boolean subTabPanelVisible;

  protected UpdateMainContentLayoutEvent() {
    // Possibly for serialization.
  }

  public UpdateMainContentLayoutEvent(boolean subTabPanelVisible) {
    this.subTabPanelVisible = subTabPanelVisible;
  }

  public static void fire(HasHandlers source, boolean subTabPanelVisible) {
    UpdateMainContentLayoutEvent eventInstance = new UpdateMainContentLayoutEvent(subTabPanelVisible);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, UpdateMainContentLayoutEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasUpdateMainContentLayoutHandlers extends HasHandlers {
    HandlerRegistration addUpdateMainContentLayoutHandler(UpdateMainContentLayoutHandler handler);
  }

  public interface UpdateMainContentLayoutHandler extends EventHandler {
    public void onUpdateMainContentLayout(UpdateMainContentLayoutEvent event);
  }

  private static final Type<UpdateMainContentLayoutHandler> TYPE = new Type<UpdateMainContentLayoutHandler>();

  public static Type<UpdateMainContentLayoutHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<UpdateMainContentLayoutHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(UpdateMainContentLayoutHandler handler) {
    handler.onUpdateMainContentLayout(this);
  }

  public boolean isSubTabPanelVisible(){
    return subTabPanelVisible;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    UpdateMainContentLayoutEvent other = (UpdateMainContentLayoutEvent) obj;
    if (subTabPanelVisible != other.subTabPanelVisible)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + new Boolean(subTabPanelVisible).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "UpdateMainContentLayoutEvent["
                 + subTabPanelVisible
    + "]";
  }
}
