package mbc.sdos.es.mbc.view.viewmodel.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.PublishingHouseDomain;
import mbc.sdos.es.mbc.view.viewmodel.PublishingHouseViewModel;

/**
 * Created by jose.fernandez on 12/11/2016.
 */

public class PublishingHouseViewModelToPublishingHouseDomain extends Mapper<PublishingHouseViewModel, PublishingHouseDomain> {

    @Inject
    public PublishingHouseViewModelToPublishingHouseDomain() {
    }

    @Override
    public PublishingHouseDomain map(PublishingHouseViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PublishingHouseViewModel reverseMap(PublishingHouseDomain value) {
        PublishingHouseViewModel publishingHouseViewModel = null;
        if (value != null) {
            publishingHouseViewModel = new PublishingHouseViewModel();
            publishingHouseViewModel.setTitle(value.getTitle());
            publishingHouseViewModel.setType(value.getType());
            publishingHouseViewModel.setTarget_uuid(value.getTarget_uuid());
        }
        return publishingHouseViewModel;
    }
}
