package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/5/27.
 */
public class PrescriptionEntityPK implements Serializable {
    private String presId;
    private String userId;

    public String getPresId() {
        return presId;
    }

    public void setPresId(String presId) {
        this.presId = presId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrescriptionEntityPK that = (PrescriptionEntityPK) o;

        if (presId != null ? !presId.equals(that.presId) : that.presId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = presId != null ? presId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
