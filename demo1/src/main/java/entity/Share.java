package entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * shares
 * @author 
 */
public class Share implements Serializable {
    private Integer shareId;

    private String shareName;

    private BigDecimal sharePrice;

    private Integer shareNumber;
    private String shareType;

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public Share() {
    }

    @Override
    public String toString() {
        return "Share{" +
                "shareId=" + shareId +
                ", shareName='" + shareName + '\'' +
                ", sharePrice=" + sharePrice +
                ", shareNumber=" + shareNumber +
                ", shareType='" + shareType + '\'' +
                '}';
    }

    private static final long serialVersionUID = 1L;

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

    public Integer getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(Integer shareNumber) {
        this.shareNumber = shareNumber;
    }
}