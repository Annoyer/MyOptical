package model;

import java.math.BigDecimal;

/**
 * Created by 86761 on 2017/6/8.
 */
public class GlassesItemEntity {
    private int glassesItemId;
    private BigDecimal glassesPrice;
    private String lensType;
    private String lensColor;
    private String lensMaterial;
    private int frameId;
    private int presId;

    public int getGlassesItemId() {
        return glassesItemId;
    }

    public void setGlassesItemId(int glassesItemId) {
        this.glassesItemId = glassesItemId;
    }

    public BigDecimal getGlassesPrice() {
        return glassesPrice;
    }

    public void setGlassesPrice(BigDecimal glassesPrice) {
        this.glassesPrice = glassesPrice;
    }

    public String getLensType() {
        return lensType;
    }

    public void setLensType(String lensType) {
        this.lensType = lensType;
    }

    public String getLensColor() {
        return lensColor;
    }

    public void setLensColor(String lensColor) {
        this.lensColor = lensColor;
    }

    public String getLensMaterial() {
        return lensMaterial;
    }

    public void setLensMaterial(String lensMaterial) {
        this.lensMaterial = lensMaterial;
    }

    public int getFrameId() {
        return frameId;
    }

    public void setFrameId(int frameId) {
        this.frameId = frameId;
    }

    public int getPresId() {
        return presId;
    }

    public void setPresId(int presId) {
        this.presId = presId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlassesItemEntity that = (GlassesItemEntity) o;

        if (glassesItemId != that.glassesItemId) return false;
        if (frameId != that.frameId) return false;
        if (presId != that.presId) return false;
        if (glassesPrice != null ? !glassesPrice.equals(that.glassesPrice) : that.glassesPrice != null) return false;
        if (lensType != null ? !lensType.equals(that.lensType) : that.lensType != null) return false;
        if (lensColor != null ? !lensColor.equals(that.lensColor) : that.lensColor != null) return false;
        if (lensMaterial != null ? !lensMaterial.equals(that.lensMaterial) : that.lensMaterial != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = glassesItemId;
        result = 31 * result + (glassesPrice != null ? glassesPrice.hashCode() : 0);
        result = 31 * result + (lensType != null ? lensType.hashCode() : 0);
        result = 31 * result + (lensColor != null ? lensColor.hashCode() : 0);
        result = 31 * result + (lensMaterial != null ? lensMaterial.hashCode() : 0);
        result = 31 * result + frameId;
        result = 31 * result + presId;
        return result;
    }
}
