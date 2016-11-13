package mbc.sdos.es.mbc.data.repository.datasource.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.entity.dto.object.RetailerApi;
import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.RetailerDomain;

public class RetailerDomainToRetailerWSMapper extends Mapper<RetailerDomain, RetailerApi> {

    @Inject
    public RetailerDomainToRetailerWSMapper() {
    }

    @Override
    public RetailerApi map(RetailerDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RetailerDomain reverseMap(RetailerApi value) {
        RetailerDomain retailerDomain = null;
        if (value != null) {
            retailerDomain = new RetailerDomain();
            retailerDomain.setType(value.getType());
            retailerDomain.setUuid(value.getUuid());
            retailerDomain.setTitle(value.getTitle());
        }
        return retailerDomain;
    }
}
