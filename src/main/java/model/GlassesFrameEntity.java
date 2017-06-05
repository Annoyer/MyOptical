package model;

/**
 * Created by 86761 on 2017/6/5.
 */
public class GlassesFrameEntity {
    private int frameId;
    private int glassesItemId;

    public int getFrameId() {
        return frameId;
    }

    public void setFrameId(int frameId) {
        this.frameId = frameId;
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

        GlassesFrameEntity that = (GlassesFrameEntity) o;

        if (frameId != that.frameId) return false;
        if (glassesItemId != that.glassesItemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = frameId;
        result = 31 * result + glassesItemId;
        return result;
    }
}
