package mbc.sdos.es.mbc.view.viewmodel;

/**
 * Created by jose.fernandez on 13/11/2016.
 */

public class RetailerLinksViewModel {

    private String revisionId;
    private String link;
    private String price;
    private RetailerViewModel retailer;
    private String targetType;

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

    public RetailerViewModel getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerViewModel retailer) {
        this.retailer = retailer;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }
}
