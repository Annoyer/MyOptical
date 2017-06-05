package model;

/**
 * Created by 86761 on 2017/6/5.
 */
public class AdditionEntity {
    private int glassesItemId;
    private int addId;
    private String addType;

    public int getGlassesItemId() {
        return glassesItemId;
    }

    public void setGlassesItemId(int glassesItemId) {
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

        if (glassesItemId != that.glassesItemId) return false;
        if (addId != that.addId) return false;
        if (addType != null ? !addType.equals(that.addType) : that.addType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = glassesItemId;
        result = 31 * result + addId;
        result = 31 * result + (addType != null ? addType.hashCode() : 0);
        return result;
    }
}
