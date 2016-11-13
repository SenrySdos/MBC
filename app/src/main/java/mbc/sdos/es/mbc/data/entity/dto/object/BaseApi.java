package mbc.sdos.es.mbc.data.entity.dto.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jose.fernandez on 10/11/2016.
 */

public class BaseApi {

    @SerializedName("int_uuid")
    private String uuid;
    @SerializedName("int_vid")
    private String vid;
    @SerializedName("int_status")
    private Integer status;
    @SerializedName("int_created")
    private Integer created;
    @SerializedName("int_changed")
    private Integer changed;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getChanged() {
        return changed;
    }

    public void setChanged(Integer changed) {
        this.changed = changed;
    }
}
