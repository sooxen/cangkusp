package com.lin.cangkusp.common.utils;

import java.util.Date;

//条件查询perchance的封装类
public class QueryPerchanceVo {
    private String cno;
    private String wno;
    private String sno;
    private Float lowestprice;
    private Float hightestprice;
    private String startdate;
    private String enddate;
    private Integer pnum;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Float getLowestprice() {
        return lowestprice;
    }

    public void setLowestprice(Float lowestprice) {
        this.lowestprice = lowestprice;
    }

    public Float getHightestprice() {
        return hightestprice;
    }

    public void setHightestprice(Float hightestprice) {
        this.hightestprice = hightestprice;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }
}
