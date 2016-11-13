package mbc.sdos.es.mbc.domain.model;

import java.util.List;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class BookDomain extends BaseDomain {

    private String title;
    private String description;
    private String image;
    private AuthorDomain author;
    private List<CategoryDomain> categories;
    private String publish_date;
    private Integer pages;
    private PublishingHouseDomain publishingHouse;
    private List<RetailerLinksDomain> retailerLinkDomains;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public AuthorDomain getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDomain author) {
        this.author = author;
    }

    public List<CategoryDomain> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDomain> categories) {
        this.categories = categories;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public PublishingHouseDomain getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouseDomain publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<RetailerLinksDomain> getRetailerLinkDomains() {
        return retailerLinkDomains;
    }

    public void setRetailerLinkDomains(List<RetailerLinksDomain> retailerLinkDomains) {
        this.retailerLinkDomains = retailerLinkDomains;
    }
}
