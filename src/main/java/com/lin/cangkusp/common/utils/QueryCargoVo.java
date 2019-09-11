package com.lin.cangkusp.common.utils;

//条件查询cargo封装类
public class QueryCargoVo {
    private String cno;
    private String cname;
    private Float lowestprice;
    private Float hightestprice;
    private String pno;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }
}