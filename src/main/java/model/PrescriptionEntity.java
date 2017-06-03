package model;

/**
 * Created by 86761 on 2017/5/27.
 */
public class PrescriptionEntity {
    private String presId;
    private String userId;
    private String presDate;
    private String presName;
    private String rSph;
    private String lSph;
    private String rCyl;
    private String lCyl;
    private String rAxis;
    private String lAxis;
    private String pd;

    public String getPresId() {
        return presId;
    }

    public void setPresId(String presId) {
        this.presId = presId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPresDate() {
        return presDate;
    }

    public void setPresDate(String presDate) {
        this.presDate = presDate;
    }

    public String getPresName() {
        return presName;
    }

    public void setPresName(String presName) {
        this.presName = presName;
    }

    public String getrSph() {
        return rSph;
    }

    public void setrSph(String rSph) {
        this.rSph = rSph;
    }

    public String getlSph() {
        return lSph;
    }

    public void setlSph(String lSph) {
        this.lSph = lSph;
    }

    public String getrCyl() {
        return rCyl;
    }

    public void setrCyl(String rCyl) {
        this.rCyl = rCyl;
    }

    public String getlCyl() {
        return lCyl;
    }

    public void setlCyl(String lCyl) {
        this.lCyl = lCyl;
    }

    public String getrAxis() {
        return rAxis;
    }

    public void setrAxis(String rAxis) {
        this.rAxis = rAxis;
    }

    public String getlAxis() {
        return lAxis;
    }

    public void setlAxis(String lAxis) {
        this.lAxis = lAxis;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrescriptionEntity that = (PrescriptionEntity) o;

        if (presId != null ? !presId.equals(that.presId) : that.presId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (presDate != null ? !presDate.equals(that.presDate) : that.presDate != null) return false;
        if (presName != null ? !presName.equals(that.presName) : that.presName != null) return false;
        if (rSph != null ? !rSph.equals(that.rSph) : that.rSph != null) return false;
        if (lSph != null ? !lSph.equals(that.lSph) : that.lSph != null) return false;
        if (rCyl != null ? !rCyl.equals(that.rCyl) : that.rCyl != null) return false;
        if (lCyl != null ? !lCyl.equals(that.lCyl) : that.lCyl != null) return false;
        if (rAxis != null ? !rAxis.equals(that.rAxis) : that.rAxis != null) return false;
        if (lAxis != null ? !lAxis.equals(that.lAxis) : that.lAxis != null) return false;
        if (pd != null ? !pd.equals(that.pd) : that.pd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = presId != null ? presId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (presDate != null ? presDate.hashCode() : 0);
        result = 31 * result + (presName != null ? presName.hashCode() : 0);
        result = 31 * result + (rSph != null ? rSph.hashCode() : 0);
        result = 31 * result + (lSph != null ? lSph.hashCode() : 0);
        result = 31 * result + (rCyl != null ? rCyl.hashCode() : 0);
        result = 31 * result + (lCyl != null ? lCyl.hashCode() : 0);
        result = 31 * result + (rAxis != null ? rAxis.hashCode() : 0);
        result = 31 * result + (lAxis != null ? lAxis.hashCode() : 0);
        result = 31 * result + (pd != null ? pd.hashCode() : 0);
        return result;
    }
}
