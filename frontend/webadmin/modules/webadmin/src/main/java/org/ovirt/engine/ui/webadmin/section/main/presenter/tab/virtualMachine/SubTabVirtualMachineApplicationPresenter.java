package org.ovirt.engine.ui.webadmin.section.main.presenter.tab.virtualMachine;

import org.ovirt.engine.core.common.businessentities.VM;
import org.ovirt.engine.ui.common.place.PlaceRequestFactory;
import org.ovirt.engine.ui.common.presenter.AbstractSubTabPresenter;
import org.ovirt.engine.ui.common.uicommon.model.SearchableDetailModelProvider;
import org.ovirt.engine.ui.common.widget.tab.ModelBoundTabData;
import org.ovirt.engine.ui.uicommonweb.models.vms.VmAppListModel;
import org.ovirt.engine.ui.uicommonweb.models.vms.VmListModel;
import org.ovirt.engine.ui.uicommonweb.place.WebAdminApplicationPlaces;
import org.ovirt.engine.ui.webadmin.ApplicationConstants;
import org.ovirt.engine.ui.webadmin.section.main.presenter.tab.VirtualMachineSelectionChangeEvent;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;

public class SubTabVirtualMachineApplicationPresenter extends AbstractSubTabPresenter<VM, VmListModel, VmAppListModel, SubTabVirtualMachineApplicationPresenter.ViewDef, SubTabVirtualMachineApplicationPresenter.ProxyDef> {

    @ProxyCodeSplit
    @NameToken(WebAdminApplicationPlaces.virtualMachineApplicationSubTabPlace)
    public interface ProxyDef extends TabContentProxyPlace<SubTabVirtualMachineApplicationPresenter> {
    }

    public interface ViewDef extends AbstractSubTabPresenter.ViewDef<VM> {
    }

    @TabInfo(container = VirtualMachineSubTabPanelPresenter.class)
    static TabData getTabData(ApplicationConstants applicationConstants,
            SearchableDetailModelProvider<String, VmListModel, VmAppListModel> modelProvider) {
        return new ModelBoundTabData(applicationConstants.virtualMachineApplicationSubTabLabel(), 5, modelProvider);
    }

    @Inject
    public SubTabVirtualMachineApplicationPresenter(EventBus eventBus, ViewDef view, ProxyDef proxy,
            PlaceManager placeManager, SearchableDetailModelProvider<String, VmListModel, VmAppListModel> modelProvider) {
        super(eventBus, view, proxy, placeManager, modelProvider,
                VirtualMachineSubTabPanelPresenter.TYPE_SetTabContent);
    }

    @Override
    protected PlaceRequest getMainTabRequest() {
        return PlaceRequestFactory.get(WebAdminApplicationPlaces.virtualMachineMainTabPlace);
    }

    @ProxyEvent
    public void onVirtualMachineSelectionChange(VirtualMachineSelectionChangeEvent event) {
        updateMainTabSelection(event.getSelectedItems());
    }

}
