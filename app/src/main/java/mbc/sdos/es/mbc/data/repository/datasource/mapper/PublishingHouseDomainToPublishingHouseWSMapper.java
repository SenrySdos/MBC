package mbc.sdos.es.mbc.data.repository.datasource.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.entity.dto.object.PublishingHouseApi;
import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.PublishingHouseDomain;

public class PublishingHouseDomainToPublishingHouseWSMapper extends Mapper<PublishingHouseDomain, PublishingHouseApi> {

    @Inject
    public PublishingHouseDomainToPublishingHouseWSMapper() {
    }

    @Override
    public PublishingHouseApi map(PublishingHouseDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PublishingHouseDomain reverseMap(PublishingHouseApi value) {
        PublishingHouseDomain publishingHouseDomain = null;
        if (value != null) {
            publishingHouseDomain = new PublishingHouseDomain();
            publishingHouseDomain.setTitle(value.getTitle());
            publishingHouseDomain.setType(value.getType());
            publishingHouseDomain.setTarget_uuid(value.getTarget_uuid());
        }
        return publishingHouseDomain;
    }
}
