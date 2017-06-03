package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/5/27.
 */
public class AddressEntityPK implements Serializable {
    private String addNo;
    private String customerId;

    public String getAddNo() {
        return addNo;
    }

    public void setAddNo(String addNo) {
        this.addNo = addNo;
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

        if (addNo != null ? !addNo.equals(that.addNo) : that.addNo != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addNo != null ? addNo.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }
}
