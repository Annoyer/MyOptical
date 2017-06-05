package model;

import java.math.BigDecimal;

/**
 * Created by 86761 on 2017/6/5.
 */
public class FrameEntity {
    private int frameId;
    private String glassesType;
    private String color;
    private String style;
    private String userType;
    private BigDecimal framePrice;
    private String form;
    private String material;
    private String framePhoto;
    private Integer accessTime;
    private String frameName;

    public int getFrameId() {
        return frameId;
    }

    public void setFrameId(int frameId) {
        this.frameId = frameId;
    }

    public String getGlassesType() {
        return glassesType;
    }

    public void setGlassesType(String glassesType) {
        this.glassesType = glassesType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public BigDecimal getFramePrice() {
        return framePrice;
    }

    public void setFramePrice(BigDecimal framePrice) {
        this.framePrice = framePrice;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getFramePhoto() {
        return framePhoto;
    }

    public void setFramePhoto(String framePhoto) {
        this.framePhoto = framePhoto;
    }

    public Integer getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Integer accessTime) {
        this.accessTime = accessTime;
    }

    public String getFrameName() {
        return frameName;
    }

    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FrameEntity that = (FrameEntity) o;

        if (frameId != that.frameId) return false;
        if (glassesType != null ? !glassesType.equals(that.glassesType) : that.glassesType != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (style != null ? !style.equals(that.style) : that.style != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;
        if (framePrice != null ? !framePrice.equals(that.framePrice) : that.framePrice != null) return false;
        if (form != null ? !form.equals(that.form) : that.form != null) return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;
        if (framePhoto != null ? !framePhoto.equals(that.framePhoto) : that.framePhoto != null) return false;
        if (accessTime != null ? !accessTime.equals(that.accessTime) : that.accessTime != null) return false;
        if (frameName != null ? !frameName.equals(that.frameName) : that.frameName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = frameId;
        result = 31 * result + (glassesType != null ? glassesType.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (framePrice != null ? framePrice.hashCode() : 0);
        result = 31 * result + (form != null ? form.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (framePhoto != null ? framePhoto.hashCode() : 0);
        result = 31 * result + (accessTime != null ? accessTime.hashCode() : 0);
        result = 31 * result + (frameName != null ? frameName.hashCode() : 0);
        return result;
    }
}
