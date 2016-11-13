package mbc.sdos.es.mbc.view.viewmodel;

import java.util.List;

/**
 * Created by jose.fernandez on 12/11/2016.
 */

public class BookViewModel extends BaseViewModel {


    private String title;
    private String description;
    private String image;
    private AuthorViewModel author;
    private List<CategoryViewModel> categories;
    private String publish_date;
    private Integer pages;
    private PublishingHouseViewModel publishingHouse;
    private List<RetailerLinksViewModel> retailerLinks;

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

    public AuthorViewModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorViewModel author) {
        this.author = author;
    }

    public List<CategoryViewModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryViewModel> categories) {
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

    public PublishingHouseViewModel getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouseViewModel publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<RetailerLinksViewModel> getRetailerLinks() {
        return retailerLinks;
    }

    public void setRetailerLinks(List<RetailerLinksViewModel> retailerLinks) {
        this.retailerLinks = retailerLinks;
    }
}
