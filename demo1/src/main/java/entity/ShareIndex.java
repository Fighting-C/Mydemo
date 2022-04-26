package entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * share_index
 * @author 
 */
public class ShareIndex implements Serializable {
    private Integer indexId;

    private Integer proId;

    private Integer shareId;

    private String shareName;

    private BigDecimal sharePrice;

    private String shareType;

    private Integer shareNumber;

    private Integer shareManage;

    public Integer getShareManage() {
        return shareManage;
    }

    public void setShareManage(Integer shareManage) {
        this.shareManage = shareManage;
    }

    private static final long serialVersionUID = 1L;

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public BigDecimal getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(BigDecimal sharePrice) {
        this.sharePrice = sharePrice;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public Integer getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(Integer shareNumber) {
        this.shareNumber = shareNumber;
    }
}