package mbc.sdos.es.mbc.data.repository;

import java.util.List;

import javax.inject.Inject;

import mbc.sdos.es.mbc.constants.EnumConstants;
import mbc.sdos.es.mbc.data.repository.datasource.LatestBooksApiDataSource;
import mbc.sdos.es.mbc.data.repository.datasource.mapper.BookDomainToBookWSMapper;
import mbc.sdos.es.mbc.domain.model.BookDomain;

public class LatestBooksRepository {

    @Inject
    public LatestBooksRepository() {
    }

    @Inject
    LatestBooksApiDataSource latestBooksApiDataSource;
    @Inject
    BookDomainToBookWSMapper bookDomainToBookWSMapper;

    public void requestBooks(EnumConstants.DataSource dataSource, RepositoryCallback<BookDomain> repositoryCallback) {

        if (dataSource == EnumConstants.DataSource.WS) {
            List<BookDomain> books = bookDomainToBookWSMapper.reverseMap(latestBooksApiDataSource.entityList());
            repositoryCallback.onSuccess(books);
        } else if (dataSource == EnumConstants.DataSource.DDBB) {

        } else {
            repositoryCallback.onError();
        }
    }

    public interface RepositoryCallback<T> {
        void onSuccess(List<T> response);

        void onError();
    }

}
