package mbc.sdos.es.mbc.data.entity.dto.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jose.fernandez on 13/11/2016.
 */

public class RetailerLinskApi {

    @SerializedName("int_revision_id")
    private String revisionId;
    @SerializedName("field_link")
    private String link;
    @SerializedName("field_price")
    private String price;
    @SerializedName("field_retailer_reference")
    private RetailerApi retailer;
    @SerializedName("targetType")
    private String targetType;
    @SerializedName("target_uuid")
    private String uuid;

    public String getRevisionId() {
        return revisionId;
    }

    public void setRevisionId(String revisionId) {
        this.revisionId = revisionId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public RetailerApi getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerApi retailer) {
        this.retailer = retailer;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
