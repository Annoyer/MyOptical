package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/5/27.
 */
public class GlassesPreEntityPK implements Serializable {
    private String presId;
    private String customerId;
    private String glassesItemId;

    public String getPresId() {
        return presId;
    }

    public void setPresId(String presId) {
        this.presId = presId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGlassesItemId() {
        return glassesItemId;
    }

    public void setGlassesItemId(String glassesItemId) {
        this.glassesItemId = glassesItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlassesPreEntityPK that = (GlassesPreEntityPK) o;

        if (presId != null ? !presId.equals(that.presId) : that.presId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (glassesItemId != null ? !glassesItemId.equals(that.glassesItemId) : that.glassesItemId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = presId != null ? presId.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (glassesItemId != null ? glassesItemId.hashCode() : 0);
        return result;
    }
}
