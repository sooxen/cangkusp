package com.lin.cangkusp.pojo;

import java.util.Date;

public class Sell {
    private String sid;

    private String cno;

    private Float sprice;

    private String wno;

    private String sno;

    private Date sdate;

    private Integer snum;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno == null ? null : cno.trim();
    }

    public Float getSprice() {
        return sprice;
    }

    public void setSprice(Float sprice) {
        this.sprice = sprice;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno == null ? null : wno.trim();
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }
}