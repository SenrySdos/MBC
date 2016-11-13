package mbc.sdos.es.mbc.domain.model;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class SourceDomain extends BaseDomain {

    private String Name;
    private String Description;
    private String Web;
    private String Image;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
