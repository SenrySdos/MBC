package mbc.sdos.es.mbc.view.viewmodel.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.BookDomain;
import mbc.sdos.es.mbc.view.viewmodel.BookViewModel;

public class BookViewModelToBookDomain extends Mapper<BookViewModel, BookDomain> {

    @Inject
    AuthorViewModelToAuthorDomain authorViewModelToAuthorDomain;
    @Inject
    CategoryViewModelToCategoryDomain categoryViewModelToCategoryDomain;
    @Inject
    PublishingHouseViewModelToPublishingHouseDomain publishingHouseViewModelToPublishingHouseDomain;
    @Inject
    RetailerLinksViewModelToRetaileLinksDomain retailerLinksViewModelToRetaileLinksDomain;

    @Inject
    public BookViewModelToBookDomain() {
    }

    @Override
    public BookDomain map(BookViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BookViewModel reverseMap(BookDomain value) {

        BookViewModel bookViewModel = null;
        if (value != null) {
            bookViewModel = new BookViewModel();
            bookViewModel.setTitle(value.getTitle());
            bookViewModel.setAuthor(authorViewModelToAuthorDomain.reverseMap(value.getAuthor()));
//            bookViewModel.setCategories(categoryViewModelToCategoryDomain.reverseMap(value.getCategories()));
            bookViewModel.setDescription(value.getDescription());
            bookViewModel.setImage(value.getImage());
            bookViewModel.setPages(value.getPages());
            bookViewModel.setPublish_date(value.getPublish_date());
            bookViewModel.setPublishingHouse(publishingHouseViewModelToPublishingHouseDomain.reverseMap(value.getPublishingHouse()));
            bookViewModel.setRetailerLinks(retailerLinksViewModelToRetaileLinksDomain.reverseMap(value.getRetailerLinkDomains()));
            bookViewModel.setTitle(value.getTitle());
            bookViewModel.setChanged(value.getChanged());
            bookViewModel.setCreated(value.getCreated());
            bookViewModel.setStatus(value.getStatus());
            bookViewModel.setUuid(value.getUuid());
            bookViewModel.setVid(value.getVid());
        }
        return bookViewModel;
    }
}
