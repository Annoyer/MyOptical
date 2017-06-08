package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/6/8.
 */
public class AddressEntityPK implements Serializable {
    private int addrId;
    private String customerId;

    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntityPK that = (AddressEntityPK) o;

        if (addrId != that.addrId) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addrId;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }
}
