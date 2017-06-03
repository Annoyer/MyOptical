package model;

/**
 * Created by 86761 on 2017/5/27.
 */
public class AddressEntity {
    private String addNo;
    private String customerId;
    private String state;
    private String city;
    private String street;
    private String other;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (addNo != null ? !addNo.equals(that.addNo) : that.addNo != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (other != null ? !other.equals(that.other) : that.other != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addNo != null ? addNo.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        return result;
    }
}
