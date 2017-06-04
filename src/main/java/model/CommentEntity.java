package model;

import java.sql.Timestamp;

/**
 * Created by 86761 on 2017/5/27.
 */
public class CommentEntity {
    private int commId;
    private String frameId;
    private String commText;
    private String commPhoto;
    private Timestamp commTime;
    private String customerId;

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

    public String getCommText() {
        return commText;
    }

    public void setCommText(String commText) {
        this.commText = commText;
    }

    public String getCommPhoto() {
        return commPhoto;
    }

    public void setCommPhoto(String commPhoto) {
        this.commPhoto = commPhoto;
    }

    public Timestamp getCommTime() {
        return commTime;
    }

    public void setCommTime(Timestamp commTime) {
        this.commTime = commTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commId != that.commId) return false;
        if (frameId != null ? !frameId.equals(that.frameId) : that.frameId != null) return false;
        if (commText != null ? !commText.equals(that.commText) : that.commText != null) return false;
        if (commPhoto != null ? !commPhoto.equals(that.commPhoto) : that.commPhoto != null) return false;
        if (commTime != null ? !commTime.equals(that.commTime) : that.commTime != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commId;
        result = 31 * result + (frameId != null ? frameId.hashCode() : 0);
        result = 31 * result + (commText != null ? commText.hashCode() : 0);
        result = 31 * result + (commPhoto != null ? commPhoto.hashCode() : 0);
        result = 31 * result + (commTime != null ? commTime.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }
}
