package mbc.sdos.es.mbc.data.repository.datasource.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.entity.dto.object.RetailerLinskApi;
import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.RetailerLinksDomain;

public class RetailerLinksDomainToRetailerLinksWSMapper extends Mapper<RetailerLinksDomain, RetailerLinskApi> {

    @Inject
    RetailerDomainToRetailerWSMapper retailerDomainToRetailerWSMapper;

    @Inject
    public RetailerLinksDomainToRetailerLinksWSMapper() {
    }

    @Override
    public RetailerLinskApi map(RetailerLinksDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RetailerLinksDomain reverseMap(RetailerLinskApi value) {
        RetailerLinksDomain retailerLinkDomain = null;
        if (value != null) {
            retailerLinkDomain = new RetailerLinksDomain();
            retailerLinkDomain.setUuid(value.getUuid());
            retailerLinkDomain.setLink(value.getLink());
            retailerLinkDomain.setPrice(value.getPrice());
            retailerLinkDomain.setRetailer(retailerDomainToRetailerWSMapper.reverseMap(value.getRetailer()));
            retailerLinkDomain.setRevisionId(value.getRevisionId());
            retailerLinkDomain.setTargetType(value.getTargetType());
        }
        return retailerLinkDomain;
    }
}
