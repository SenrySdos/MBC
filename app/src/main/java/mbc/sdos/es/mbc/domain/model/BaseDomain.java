package mbc.sdos.es.mbc.domain.model;

import java.util.Date;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class BaseDomain {

    private String uuid;
    private String vid;
    private Integer status;
    private Integer created;
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
