package model;

/**
 * Created by 86761 on 2017/5/27.
 */
public class GlassesFrameEntity {
    private String frameId;
    private String glassesItemId;

    public String getFrameId() {
        return frameId;
    }

    public void setFrameId(String frameId) {
        this.frameId = frameId;
    }

    public String getGlassesItemId() {
        return glassesItemId;
    }

    public void setGlassesItemId(String glassesItemId) {
        this.glassesItemId = glassesItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlassesFrameEntity that = (GlassesFrameEntity) o;

        if (frameId != null ? !frameId.equals(that.frameId) : that.frameId != null) return false;
        if (glassesItemId != null ? !glassesItemId.equals(that.glassesItemId) : that.glassesItemId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = frameId != null ? frameId.hashCode() : 0;
        result = 31 * result + (glassesItemId != null ? glassesItemId.hashCode() : 0);
        return result;
    }
}
