package model;

/**
 * Created by 86761 on 2017/5/27.
 */
public class AdditionEntity {
    private String glassesItemId;
    private int addId;
    private String addType;

    public String getGlassesItemId() {
        return glassesItemId;
    }

    public void setGlassesItemId(String glassesItemId) {
        this.glassesItemId = glassesItemId;
    }

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public String getAddType() {
        return addType;
    }

    public void setAddType(String addType) {
        this.addType = addType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdditionEntity that = (AdditionEntity) o;

        if (addId != that.addId) return false;
        if (glassesItemId != null ? !glassesItemId.equals(that.glassesItemId) : that.glassesItemId != null)
            return false;
        if (addType != null ? !addType.equals(that.addType) : that.addType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = glassesItemId != null ? glassesItemId.hashCode() : 0;
        result = 31 * result + addId;
        result = 31 * result + (addType != null ? addType.hashCode() : 0);
        return result;
    }
}
