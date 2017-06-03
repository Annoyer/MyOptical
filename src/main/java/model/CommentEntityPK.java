package model;

import java.io.Serializable;

/**
 * Created by 86761 on 2017/5/27.
 */
public class CommentEntityPK implements Serializable {
    private String commId;
    private String frameId;

    public String getCommId() {
        return commId;
    }

    public void setCommId(String commId) {
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

        if (commId != null ? !commId.equals(that.commId) : that.commId != null) return false;
        if (frameId != null ? !frameId.equals(that.frameId) : that.frameId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commId != null ? commId.hashCode() : 0;
        result = 31 * result + (frameId != null ? frameId.hashCode() : 0);
        return result;
    }
}
