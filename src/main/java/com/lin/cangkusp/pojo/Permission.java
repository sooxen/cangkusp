package com.lin.cangkusp.pojo;

public class Permission {
    private Integer perno;

    private String pername;

    public Integer getPerno() {
        return perno;
    }

    public void setPerno(Integer perno) {
        this.perno = perno;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername == null ? null : pername.trim();
    }
}