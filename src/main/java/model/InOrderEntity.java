package model;

/**
 * Created by 86761 on 2017/6/5.
 */
public class InOrderEntity {
    private int glassesItemId;
    private int orderId;
    private Integer itemCount;

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

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InOrderEntity that = (InOrderEntity) o;

        if (glassesItemId != that.glassesItemId) return false;
        if (orderId != that.orderId) return false;
        if (itemCount != null ? !itemCount.equals(that.itemCount) : that.itemCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = glassesItemId;
        result = 31 * result + orderId;
        result = 31 * result + (itemCount != null ? itemCount.hashCode() : 0);
        return result;
    }
}
