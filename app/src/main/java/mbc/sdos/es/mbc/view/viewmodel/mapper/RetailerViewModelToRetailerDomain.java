package mbc.sdos.es.mbc.view.viewmodel.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.RetailerDomain;
import mbc.sdos.es.mbc.view.viewmodel.RetailerViewModel;

/**
 * Created by jose.fernandez on 12/11/2016.
 */

public class RetailerViewModelToRetailerDomain extends Mapper<RetailerViewModel, RetailerDomain> {

    @Inject
    public RetailerViewModelToRetailerDomain() {
    }

    @Override
    public RetailerDomain map(RetailerViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RetailerViewModel reverseMap(RetailerDomain value) {
        RetailerViewModel retailer = null;
        if (retailer != null) {
            retailer = new RetailerViewModel();
            retailer.setUuid(value.getUuid());
            retailer.setTitle(value.getTitle());
            retailer.setType(value.getType());
        }
        return retailer;
    }
}
