package model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by 86761 on 2017/6/5.
 */
public class OrderInfoEntity {
    private int orderId;
    private BigDecimal totalPrice;
    private String customerId;
    private Integer addrId;
    private Timestamp orderTime;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfoEntity that = (OrderInfoEntity) o;

        if (orderId != that.orderId) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (addrId != null ? !addrId.equals(that.addrId) : that.addrId != null) return false;
        if (orderTime != null ? !orderTime.equals(that.orderTime) : that.orderTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (addrId != null ? addrId.hashCode() : 0);
        result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
        return result;
    }
}
