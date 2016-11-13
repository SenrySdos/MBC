package mbc.sdos.es.mbc.data.entity.dto.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mbc.sdos.es.mbc.data.entity.dto.object.PaginationApi;

/**
 * Created by jose.fernandez on 13/11/2016.
 */

public class BaseResponseApi<T> {

    @SerializedName("results")
    private List<T> results;
    @SerializedName("pagination")
    private PaginationApi pagination;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public PaginationApi getPagination() {
        return pagination;
    }

    public void setPagination(PaginationApi pagination) {
        this.pagination = pagination;
    }
}
