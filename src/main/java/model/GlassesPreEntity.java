package model;

/**
 * Created by 86761 on 2017/6/5.
 */
public class GlassesPreEntity {
    private int presId;
    private int glassesItemId;

    public int getPresId() {
        return presId;
    }

    public void setPresId(int presId) {
        this.presId = presId;
    }

    public int getGlassesItemId() {
        return glassesItemId;
    }

    public void setGlassesItemId(int glassesItemId) {
        this.glassesItemId = glassesItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlassesPreEntity that = (GlassesPreEntity) o;

        if (presId != that.presId) return false;
        if (glassesItemId != that.glassesItemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = presId;
        result = 31 * result + glassesItemId;
        return result;
    }
}
