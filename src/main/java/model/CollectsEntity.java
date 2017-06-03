package model;

/**
 * Created by 86761 on 2017/5/27.
 */
public class CollectsEntity {
    private String id;
    private String frameId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrameId() {
        return frameId;
    }

    public void setFrameId(String frameId) {
        this.frameId = frameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectsEntity that = (CollectsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (frameId != null ? !frameId.equals(that.frameId) : that.frameId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (frameId != null ? frameId.hashCode() : 0);
        return result;
    }
}
