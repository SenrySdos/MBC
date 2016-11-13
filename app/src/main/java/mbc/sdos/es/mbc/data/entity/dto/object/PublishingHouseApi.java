package mbc.sdos.es.mbc.data.entity.dto.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class PublishingHouseApi {

    @SerializedName("name")
    private String target_uuid;
    @SerializedName("target_type")
    private String type;
    @SerializedName("title")
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
