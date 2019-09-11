package com.lin.cangkusp.pojo;

public class Warehouse {
    private String wno;

    private String wname;

    private String waddress;

    private String sno;

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno == null ? null : wno.trim();
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname == null ? null : wname.trim();
    }

    public String getWaddress() {
        return waddress;
    }

    public void setWaddress(String waddress) {
        this.waddress = waddress == null ? null : waddress.trim();
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }
}