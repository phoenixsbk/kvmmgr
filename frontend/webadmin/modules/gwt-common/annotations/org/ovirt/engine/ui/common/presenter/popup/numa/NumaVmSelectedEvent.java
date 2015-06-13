package org.ovirt.engine.ui.common.presenter.popup.numa;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class NumaVmSelectedEvent extends GwtEvent<NumaVmSelectedEvent.NumaVmSelectedHandler> { 

  org.ovirt.engine.ui.uicommonweb.models.hosts.numa.VNodeModel vNodeModel;

  protected NumaVmSelectedEvent() {
    // Possibly for serialization.
  }

  public NumaVmSelectedEvent(org.ovirt.engine.ui.uicommonweb.models.hosts.numa.VNodeModel vNodeModel) {
    this.vNodeModel = vNodeModel;
  }

  public static void fire(HasHandlers source, org.ovirt.engine.ui.uicommonweb.models.hosts.numa.VNodeModel vNodeModel) {
    NumaVmSelectedEvent eventInstance = new NumaVmSelectedEvent(vNodeModel);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, NumaVmSelectedEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasNumaVmSelectedHandlers extends HasHandlers {
    HandlerRegistration addNumaVmSelectedHandler(NumaVmSelectedHandler handler);
  }

  public interface NumaVmSelectedHandler extends EventHandler {
    public void onNumaVmSelected(NumaVmSelectedEvent event);
  }

  private static final Type<NumaVmSelectedHandler> TYPE = new Type<NumaVmSelectedHandler>();

  public static Type<NumaVmSelectedHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<NumaVmSelectedHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(NumaVmSelectedHandler handler) {
    handler.onNumaVmSelected(this);
  }

  public org.ovirt.engine.ui.uicommonweb.models.hosts.numa.VNodeModel getVNodeModel(){
    return vNodeModel;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    NumaVmSelectedEvent other = (NumaVmSelectedEvent) obj;
    if (vNodeModel == null) {
      if (other.vNodeModel != null)
        return false;
    } else if (!vNodeModel.equals(other.vNodeModel))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (vNodeModel == null ? 1 : vNodeModel.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "NumaVmSelectedEvent["
                 + vNodeModel
    + "]";
  }
}
