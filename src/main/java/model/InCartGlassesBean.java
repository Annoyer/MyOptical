package model;

import java.math.BigDecimal;

/**
 * Created by 86761 on 2017/6/10.
 */
public class InCartGlassesBean {
    private int glassesItemId;
    private BigDecimal glassesPrice;
//    private String lensType;
//    private String lensColor;
//    private String lensMaterial;
    private int frameId;
    private int presId;

    private String framePhoto;
    private String frameName;

    private BigDecimal rSph;
    private BigDecimal lSph;
    private BigDecimal rCyl;
    private BigDecimal lCyl;
    private Integer rAxis;
    private Integer lAxis;
    private Integer pd;

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

    public String getFramePhoto() {
        return framePhoto;
    }

    public void setFramePhoto(String framePhoto) {
        this.framePhoto = framePhoto;
    }

    public String getFrameName() {
        return frameName;
    }

    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }

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

//    public String getLensType() {
//        return lensType;
//    }
//
//    public void setLensType(String lensType) {
//        this.lensType = lensType;
//    }
//
//    public String getLensColor() {
//        return lensColor;
//    }
//
//    public void setLensColor(String lensColor) {
//        this.lensColor = lensColor;
//    }
//
//    public String getLensMaterial() {
//        return lensMaterial;
//    }
//
//    public void setLensMaterial(String lensMaterial) {
//        this.lensMaterial = lensMaterial;
//    }

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
}
