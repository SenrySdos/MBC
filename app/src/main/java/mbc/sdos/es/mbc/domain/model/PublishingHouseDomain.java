package mbc.sdos.es.mbc.domain.model;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class PublishingHouseDomain {

    private String target_uuid;
    private String type;
    private String title;

    public String getTarget_uuid() {
        return target_uuid;
    }

    public void setTarget_uuid(String target_uuid) {
        this.target_uuid = target_uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
