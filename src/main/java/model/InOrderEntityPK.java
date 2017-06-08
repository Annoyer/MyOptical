package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/6/8.
 */
public class InOrderEntityPK implements Serializable {
    private int glassesItemId;
    private int orderId;

    public int getGlassesItemId() {
        return glassesItemId;
    }

    public void setGlassesItemId(int glassesItemId) {
        this.glassesItemId = glassesItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InOrderEntityPK that = (InOrderEntityPK) o;

        if (glassesItemId != that.glassesItemId) return false;
        if (orderId != that.orderId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = glassesItemId;
        result = 31 * result + orderId;
        return result;
    }
}
