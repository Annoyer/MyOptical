package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/5/27.
 */
public class CommentEntityPK implements Serializable {
    private int commId;
    private String frameId;

    public int getCommId() {
        return commId;
    }

    public void setCommId(int commId) {
        this.commId = commId;
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

        CommentEntityPK that = (CommentEntityPK) o;

        if (commId != that.commId) return false;
        if (frameId != null ? !frameId.equals(that.frameId) : that.frameId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commId;
        result = 31 * result + (frameId != null ? frameId.hashCode() : 0);
        return result;
    }
}
