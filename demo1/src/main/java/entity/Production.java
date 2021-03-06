package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * production
 * @author 
 */
public class Production implements Serializable {
    private Integer proCang;

    private BigDecimal proNowGet;

    private BigDecimal proMonGet;

    public Integer getProCang() {
        return proCang;
    }

    public void setProCang(Integer proCang) {
        this.proCang = proCang;
    }

    public BigDecimal getProNowGet() {
        return proNowGet;
    }

    public void setProNowGet(BigDecimal proNowGet) {
        this.proNowGet = proNowGet;
    }

    public BigDecimal getProMonGet() {
        return proMonGet;
    }

    public void setProMonGet(BigDecimal proMonGet) {
        this.proMonGet = proMonGet;
    }

    private Integer proId;

    private String proName;

    private String proType;

    /**
     * 当前管理资产
     */
    private Integer proManage;

    /**
     * 当前募集时间
     */
    private Date proBetime;

    /**
     * 募集结束时间
     */
    private Date proEndtime;

    public Production() {
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    /**
     * 上次分红时间
     */
    private Date proLasttime;

    private String proStatus;

    public Production(String proName, String proType, Date proBetime, Date proEndtime) {
        this.proName = proName;
        this.proType = proType;
        this.proBetime = proBetime;
        this.proEndtime = proEndtime;
    }

    private static final long serialVersionUID = 1L;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public Integer getProManage() {
        return proManage;
    }

    public void setProManage(Integer proManage) {
        this.proManage = proManage;
    }

    public Date getProBetime() {
        return proBetime;
    }

    public void setProBetime(Date proBetime) {
        this.proBetime = proBetime;
    }

    public Date getProEndtime() {
        return proEndtime;
    }

    public void setProEndtime(Date proEndtime) {
        this.proEndtime = proEndtime;
    }

    public Date getProLasttime() {
        return proLasttime;
    }

    public void setProLasttime(Date proLasttime) {
        this.proLasttime = proLasttime;
    }



}