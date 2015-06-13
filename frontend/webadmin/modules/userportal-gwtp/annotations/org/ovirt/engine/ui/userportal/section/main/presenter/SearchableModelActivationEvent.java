package org.ovirt.engine.ui.userportal.section.main.presenter;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class SearchableModelActivationEvent extends GwtEvent<SearchableModelActivationEvent.SearchableModelActivationHandler> { 

  org.ovirt.engine.ui.uicommonweb.models.SearchableListModel listModel;

  protected SearchableModelActivationEvent() {
    // Possibly for serialization.
  }

  public SearchableModelActivationEvent(org.ovirt.engine.ui.uicommonweb.models.SearchableListModel listModel) {
    this.listModel = listModel;
  }

  public static void fire(HasHandlers source, org.ovirt.engine.ui.uicommonweb.models.SearchableListModel listModel) {
    SearchableModelActivationEvent eventInstance = new SearchableModelActivationEvent(listModel);
    source.fireEvent(eventInstance);
  }

  public static void fire(HasHandlers source, SearchableModelActivationEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasSearchableModelActivationHandlers extends HasHandlers {
    HandlerRegistration addSearchableModelActivationHandler(SearchableModelActivationHandler handler);
  }

  public interface SearchableModelActivationHandler extends EventHandler {
    public void onSearchableModelActivation(SearchableModelActivationEvent event);
  }

  private static final Type<SearchableModelActivationHandler> TYPE = new Type<SearchableModelActivationHandler>();

  public static Type<SearchableModelActivationHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<SearchableModelActivationHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(SearchableModelActivationHandler handler) {
    handler.onSearchableModelActivation(this);
  }

  public org.ovirt.engine.ui.uicommonweb.models.SearchableListModel getListModel(){
    return listModel;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    SearchableModelActivationEvent other = (SearchableModelActivationEvent) obj;
    if (listModel == null) {
      if (other.listModel != null)
        return false;
    } else if (!listModel.equals(other.listModel))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (listModel == null ? 1 : listModel.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "SearchableModelActivationEvent["
                 + listModel
    + "]";
  }
}
