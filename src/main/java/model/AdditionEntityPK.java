package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/6/5.
 */
public class AdditionEntityPK implements Serializable {
    private int glassesItemId;
    private int addId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdditionEntityPK that = (AdditionEntityPK) o;

        if (glassesItemId != that.glassesItemId) return false;
        if (addId != that.addId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = glassesItemId;
        result = 31 * result + addId;
        return result;
    }
}
