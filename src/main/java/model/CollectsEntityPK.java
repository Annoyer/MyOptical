package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/6/8.
 */
public class CollectsEntityPK implements Serializable {
    private String customerId;
    private int frameId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getFrameId() {
        return frameId;
    }

    public void setFrameId(int frameId) {
        this.frameId = frameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectsEntityPK that = (CollectsEntityPK) o;

        if (frameId != that.frameId) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + frameId;
        return result;
    }
}
