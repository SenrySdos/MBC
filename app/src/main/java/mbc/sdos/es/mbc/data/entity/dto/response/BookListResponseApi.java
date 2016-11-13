package mbc.sdos.es.mbc.data.entity.dto.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mbc.sdos.es.mbc.data.entity.dto.object.BookApi;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class BookListResponseApi {

    @SerializedName("books")
    private List<BookApi> books;

    public List<BookApi> getBooks() {
        return books;
    }
}
