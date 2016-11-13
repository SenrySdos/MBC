package mbc.sdos.es.mbc.view.viewmodel.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.RetailerLinksDomain;
import mbc.sdos.es.mbc.view.viewmodel.RetailerLinksViewModel;

/**
 * Created by jose.fernandez on 12/11/2016.
 */

public class RetailerLinksViewModelToRetaileLinksDomain extends Mapper<RetailerLinksViewModel, RetailerLinksDomain> {

    @Inject
    RetailerViewModelToRetailerDomain retailerViewModelToRetailerDomain;

    @Inject
    public RetailerLinksViewModelToRetaileLinksDomain() {
    }

    @Override
    public RetailerLinksDomain map(RetailerLinksViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RetailerLinksViewModel reverseMap(RetailerLinksDomain value) {
        RetailerLinksViewModel retailer = null;
        if (retailer != null) {
            retailer = new RetailerLinksViewModel();
            retailer.setLink(value.getLink());
            retailer.setPrice(value.getPrice());
            retailer.setRetailer(retailerViewModelToRetailerDomain.reverseMap(value.getRetailer()));
            retailer.setRevisionId(value.getRevisionId());
            retailer.setTargetType(value.getTargetType());
        }
        return retailer;
    }
}
