package model;

/**
 * Created by 86761 on 2017/5/27.
 */
public class OrderInfoEntity {
    private String orderId;
    private String orderTime;
    private String totalPrice;
    private String customerId;
    private String addNo;
    private String orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddNo() {
        return addNo;
    }

    public void setAddNo(String addNo) {
        this.addNo = addNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfoEntity that = (OrderInfoEntity) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (orderTime != null ? !orderTime.equals(that.orderTime) : that.orderTime != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (addNo != null ? !addNo.equals(that.addNo) : that.addNo != null) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (addNo != null ? addNo.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        return result;
    }
}
