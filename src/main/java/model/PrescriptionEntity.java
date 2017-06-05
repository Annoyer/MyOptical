package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by 86761 on 2017/6/5.
 */
public class PrescriptionEntity {
    private int presId;
    private String customerId;
    private String presName;
    private BigDecimal rSph;
    private BigDecimal lSph;
    private BigDecimal rCyl;
    private BigDecimal lCyl;
    private Integer rAxis;
    private Integer lAxis;
    private Integer pd;
    private Timestamp presTime;

    public int getPresId() {
        return presId;
    }

    public void setPresId(int presId) {
        this.presId = presId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPresName() {
        return presName;
    }

    public void setPresName(String presName) {
        this.presName = presName;
    }

    public BigDecimal getrSph() {
        return rSph;
    }

    public void setrSph(BigDecimal rSph) {
        this.rSph = rSph;
    }

    public BigDecimal getlSph() {
        return lSph;
    }

    public void setlSph(BigDecimal lSph) {
        this.lSph = lSph;
    }

    public BigDecimal getrCyl() {
        return rCyl;
    }

    public void setrCyl(BigDecimal rCyl) {
        this.rCyl = rCyl;
    }

    public BigDecimal getlCyl() {
        return lCyl;
    }

    public void setlCyl(BigDecimal lCyl) {
        this.lCyl = lCyl;
    }

    public Integer getrAxis() {
        return rAxis;
    }

    public void setrAxis(Integer rAxis) {
        this.rAxis = rAxis;
    }

    public Integer getlAxis() {
        return lAxis;
    }

    public void setlAxis(Integer lAxis) {
        this.lAxis = lAxis;
    }

    public Integer getPd() {
        return pd;
    }

    public void setPd(Integer pd) {
        this.pd = pd;
    }

    public Timestamp getPresTime() {
        return presTime;
    }

    public void setPresTime(Timestamp presTime) {
        this.presTime = presTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrescriptionEntity that = (PrescriptionEntity) o;

        if (presId != that.presId) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (presName != null ? !presName.equals(that.presName) : that.presName != null) return false;
        if (rSph != null ? !rSph.equals(that.rSph) : that.rSph != null) return false;
        if (lSph != null ? !lSph.equals(that.lSph) : that.lSph != null) return false;
        if (rCyl != null ? !rCyl.equals(that.rCyl) : that.rCyl != null) return false;
        if (lCyl != null ? !lCyl.equals(that.lCyl) : that.lCyl != null) return false;
        if (rAxis != null ? !rAxis.equals(that.rAxis) : that.rAxis != null) return false;
        if (lAxis != null ? !lAxis.equals(that.lAxis) : that.lAxis != null) return false;
        if (pd != null ? !pd.equals(that.pd) : that.pd != null) return false;
        if (presTime != null ? !presTime.equals(that.presTime) : that.presTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = presId;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (presName != null ? presName.hashCode() : 0);
        result = 31 * result + (rSph != null ? rSph.hashCode() : 0);
        result = 31 * result + (lSph != null ? lSph.hashCode() : 0);
        result = 31 * result + (rCyl != null ? rCyl.hashCode() : 0);
        result = 31 * result + (lCyl != null ? lCyl.hashCode() : 0);
        result = 31 * result + (rAxis != null ? rAxis.hashCode() : 0);
        result = 31 * result + (lAxis != null ? lAxis.hashCode() : 0);
        result = 31 * result + (pd != null ? pd.hashCode() : 0);
        result = 31 * result + (presTime != null ? presTime.hashCode() : 0);
        return result;
    }
}
