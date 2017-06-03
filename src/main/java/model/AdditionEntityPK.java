package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/5/27.
 */
public class AdditionEntityPK implements Serializable {
    private String glassesItemId;
    private int addId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdditionEntityPK that = (AdditionEntityPK) o;

        if (addId != that.addId) return false;
        if (glassesItemId != null ? !glassesItemId.equals(that.glassesItemId) : that.glassesItemId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = glassesItemId != null ? glassesItemId.hashCode() : 0;
        result = 31 * result + addId;
        return result;
    }
}
