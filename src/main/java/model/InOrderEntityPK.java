package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/5/27.
 */
public class InOrderEntityPK implements Serializable {
    private String glassesItemId;
    private String orderId;

    public String getGlassesItemId() {
        return glassesItemId;
    }

    public void setGlassesItemId(String glassesItemId) {
        this.glassesItemId = glassesItemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InOrderEntityPK that = (InOrderEntityPK) o;

        if (glassesItemId != null ? !glassesItemId.equals(that.glassesItemId) : that.glassesItemId != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = glassesItemId != null ? glassesItemId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }
}
