package mbc.sdos.es.mbc.domain.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import mbc.sdos.es.mbc.constants.EnumConstants;
import mbc.sdos.es.mbc.data.repository.LatestBooksRepository;
import mbc.sdos.es.mbc.domain.model.BookDomain;
import mbc.sdos.es.mbc.domain.usecase.base.UseCase;

@Singleton
public class GetLatestBooksApiUC extends
        UseCase<GetLatestBooksApiUC.RequestValues, GetLatestBooksApiUC.ResponseValue> {

    @Inject
    LatestBooksRepository latestBooksRepository;

    @Inject
    public GetLatestBooksApiUC() {
    }


    @Override
    public void executeUseCase(GetLatestBooksApiUC.RequestValues requestValues,
                               final UseCaseCallback<ResponseValue> callback) {

        latestBooksRepository.requestBooks(EnumConstants.DataSource.WS, new LatestBooksRepository.RepositoryCallback<BookDomain>() {
            @Override
            public void onSuccess(List<BookDomain> response) {
                ResponseValue responseValue = new ResponseValue(response);
                callback.onSuccess(responseValue);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    public static final class RequestValues implements UseCase.RequestValues {
        public RequestValues() {
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {
        List<BookDomain> response;

        public ResponseValue(List<BookDomain> response) {
            this.response = response;
        }

        public List<BookDomain> getBooks() {
            List<BookDomain> result = new ArrayList<>(response);
            return result;
        }
    }
}
