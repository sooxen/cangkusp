package com.lin.cangkusp.pojo;

import java.util.Date;

public class Store {
    private String stno;

    private String cno;

    private String wno;

    private Integer stnum;

    private Date stdate;

    public String getStno() {
        return stno;
    }

    public void setStno(String stno) {
        this.stno = stno == null ? null : stno.trim();
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno == null ? null : cno.trim();
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno == null ? null : wno.trim();
    }

    public Integer getStnum() {
        return stnum;
    }

    public void setStnum(Integer stnum) {
        this.stnum = stnum;
    }

    public Date getStdate() {
        return stdate;
    }

    public void setStdate(Date stdate) {
        this.stdate = stdate;
    }
}