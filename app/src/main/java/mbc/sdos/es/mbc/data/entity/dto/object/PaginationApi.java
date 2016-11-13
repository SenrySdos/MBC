package mbc.sdos.es.mbc.data.entity.dto.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jose.fernandez on 13/11/2016.
 */

public class PaginationApi {

    @SerializedName("prev")
    private String prev;
    @SerializedName("next")
    private String next;

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
