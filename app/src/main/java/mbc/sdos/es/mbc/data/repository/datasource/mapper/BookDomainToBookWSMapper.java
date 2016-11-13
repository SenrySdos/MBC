package mbc.sdos.es.mbc.data.repository.datasource.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.entity.dto.object.BookApi;
import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.BookDomain;

public class BookDomainToBookWSMapper extends Mapper<BookDomain, BookApi> {
    @Inject
    AuthorDomainToAuthorWSMapper authorDomainToAuthorWSMapper;
    @Inject
    CategoryDomainToCategoryWSMapper categoryDomainToCategoryWSMapper;
    @Inject
    PublishingHouseDomainToPublishingHouseWSMapper publishingHouseDomainToPublishingHouseWSMapper;
    @Inject
    RetailerLinksDomainToRetailerLinksWSMapper retailerLinkDomainToRetailerLinWSMapper;


    @Inject
    public BookDomainToBookWSMapper() {
    }

    @Override
    public BookApi map(BookDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BookDomain reverseMap(BookApi value) {
        BookDomain bookDomain = null;
        if (value != null) {
            bookDomain = new BookDomain();
            bookDomain.setImage(value.getImage());
            bookDomain.setDescription(value.getDescription());
            bookDomain.setChanged(value.getChanged());
            bookDomain.setAuthor(authorDomainToAuthorWSMapper.reverseMap(value.getAuthor()));
//            bookDomain.setCategories(categoryDomainToCategoryWSMapper.reverseMap(value.getCategories()));
            bookDomain.setPages(value.getPages());
            bookDomain.setPublish_date(value.getPublish_date());
            bookDomain.setPublishingHouse(publishingHouseDomainToPublishingHouseWSMapper.reverseMap(value.getPublishingHouse()));
            bookDomain.setRetailerLinkDomains(retailerLinkDomainToRetailerLinWSMapper.reverseMap(value.getRetailersLinks()));
            bookDomain.setTitle(value.getTitle());
            bookDomain.setCreated(value.getCreated());
            bookDomain.setStatus(value.getStatus());
            bookDomain.setUuid(value.getUuid());
            bookDomain.setVid(value.getVid());
        }
        return bookDomain;
    }
}
