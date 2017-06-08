package model;

/**
 * Created by 86761 on 2017/6/8.
 */
public class InCartEntity {
    private int glassesItemId;
    private String customerId;

    public int getGlassesItemId() {
        return glassesItemId;
    }

    public void setGlassesItemId(int glassesItemId) {
        this.glassesItemId = glassesItemId;
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

        InCartEntity that = (InCartEntity) o;

        if (glassesItemId != that.glassesItemId) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = glassesItemId;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }
}
