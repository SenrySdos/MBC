package mbc.sdos.es.mbc.data.entity.dto.object;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class BookApi extends BaseApi {

    @SerializedName("int_title")
    private String title;
    @SerializedName("field_body")
    private String description;
    @SerializedName("field_image")
    private String image;
    @SerializedName("field_author_reference")
    private AuthorApi author;
    @SerializedName("field_categories")
    private List<CategoryApi> categories;
    @SerializedName("field_publish_date")
    private String publish_date;
    @SerializedName("pages")
    private Integer pages;
    @SerializedName("field_publishing_house_reference")
    private PublishingHouseApi publishingHouse;
    @SerializedName("field_retailers_links")
    private List<RetailerLinskApi> retailersLinks;

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

    public AuthorApi getAuthor() {
        return author;
    }

    public void setAuthor(AuthorApi author) {
        this.author = author;
    }

    public List<CategoryApi> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryApi> categories) {
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

    public PublishingHouseApi getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouseApi publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<RetailerLinskApi> getRetailersLinks() {
        return retailersLinks;
    }

    public void setRetailersLinks(List<RetailerLinskApi> retailersLinks) {
        this.retailersLinks = retailersLinks;
    }
}
