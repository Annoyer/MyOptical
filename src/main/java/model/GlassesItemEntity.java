package model;

import java.math.BigDecimal;

/**
 * Created by 86761 on 2017/5/27.
 */
public class GlassesItemEntity {
    private String glassesItemId;
    private BigDecimal price;
    private String lensType;
    private String lensColor;
    private String lensTint;

    public String getGlassesItemId() {
        return glassesItemId;
    }

    public void setGlassesItemId(String glassesItemId) {
        this.glassesItemId = glassesItemId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getLensTint() {
        return lensTint;
    }

    public void setLensTint(String lensTint) {
        this.lensTint = lensTint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlassesItemEntity that = (GlassesItemEntity) o;

        if (glassesItemId != null ? !glassesItemId.equals(that.glassesItemId) : that.glassesItemId != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (lensType != null ? !lensType.equals(that.lensType) : that.lensType != null) return false;
        if (lensColor != null ? !lensColor.equals(that.lensColor) : that.lensColor != null) return false;
        if (lensTint != null ? !lensTint.equals(that.lensTint) : that.lensTint != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = glassesItemId != null ? glassesItemId.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (lensType != null ? lensType.hashCode() : 0);
        result = 31 * result + (lensColor != null ? lensColor.hashCode() : 0);
        result = 31 * result + (lensTint != null ? lensTint.hashCode() : 0);
        return result;
    }
}
