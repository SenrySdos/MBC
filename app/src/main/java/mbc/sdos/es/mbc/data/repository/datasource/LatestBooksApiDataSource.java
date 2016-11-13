package mbc.sdos.es.mbc.data.repository.datasource;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.entity.dto.object.BookApi;
import mbc.sdos.es.mbc.data.entity.dto.response.BaseResponseApi;
import mbc.sdos.es.mbc.data.repository.datasource.mapper.BookDomainToBookWSMapper;
import mbc.sdos.es.mbc.data.ws.MBCWs;
import mbc.sdos.es.mbc.domain.usecase.GetLatestBooksApiUC;
import retrofit2.Call;
import retrofit2.Response;

public class LatestBooksApiDataSource implements DataSource<BookApi> {

    @Inject
    public LatestBooksApiDataSource() {
    }

    @Inject
    MBCWs mbcWs;

    @Override
    public List<BookApi> entityList() {
        List<BookApi> books = null;
        BookDomainToBookWSMapper bookDomainToBookWSMapper = new BookDomainToBookWSMapper();
        GetLatestBooksApiUC.ResponseValue responseValue;

        Call<BaseResponseApi<BookApi>> call = mbcWs.getBookList();
        try {
            Response<BaseResponseApi<BookApi>> callResponse = call.execute();
            if (callResponse.isSuccessful()) {
                BaseResponseApi<BookApi> responseDTO = callResponse.body();
                books = responseDTO.getResults();
            }
        } catch (IOException e) {
            Log.d("Retrofit Error", "error to call list of books");
        }
        return books;
    }

    @Override
    public BookApi entityDetail(String flag) {
        return null;
    }
}
