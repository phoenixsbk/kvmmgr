package org.ovirt.engine.ui.common.widget.tab;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class TabAccessibleChangeEvent extends GwtEvent<TabAccessibleChangeEvent.TabAccessibleChangeHandler> { 

  org.ovirt.engine.ui.common.widget.tab.ModelBoundTab tab;

  protected TabAccessibleChangeEvent() {
    // Possibly for serialization.
  }

  public TabAccessibleChangeEvent(org.ovirt.engine.ui.common.widget.tab.ModelBoundTab tab) {
    this.tab = tab;
  }

  public static void fire(HasHandlers source, org.ovirt.engine.ui.common.widget.tab.ModelBoundTab tab) {
    TabAccessibleChangeEvent eventInstance = new TabAccessibleChangeEvent(tab);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, TabAccessibleChangeEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasTabAccessibleChangeHandlers extends HasHandlers {
    HandlerRegistration addTabAccessibleChangeHandler(TabAccessibleChangeHandler handler);
  }

  public interface TabAccessibleChangeHandler extends EventHandler {
    public void onTabAccessibleChange(TabAccessibleChangeEvent event);
  }

  private static final Type<TabAccessibleChangeHandler> TYPE = new Type<TabAccessibleChangeHandler>();

  public static Type<TabAccessibleChangeHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<TabAccessibleChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(TabAccessibleChangeHandler handler) {
    handler.onTabAccessibleChange(this);
  }

  public org.ovirt.engine.ui.common.widget.tab.ModelBoundTab getTab(){
    return tab;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    TabAccessibleChangeEvent other = (TabAccessibleChangeEvent) obj;
    if (tab == null) {
      if (other.tab != null)
        return false;
    } else if (!tab.equals(other.tab))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (tab == null ? 1 : tab.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "TabAccessibleChangeEvent["
                 + tab
    + "]";
  }
}
