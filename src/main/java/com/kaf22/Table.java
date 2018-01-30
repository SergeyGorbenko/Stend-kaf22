package com.kaf22;

import java.util.Date;
import java.util.Iterator;

public class Table{
    private int grup;
    private String audit;
    private String leson;
    private String ticher;
    private Date date;
    private int para;

    public Table()  {
    }

    public int getGrup() {
        return grup;
    }

    public void setGrup(int grup) {
        this.grup = grup;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getLeson() {
        return leson;
    }

    public void setLeson(String leson) {
        this.leson = leson;
    }

    public String getTicher() {
        return ticher;
    }

    public void setTicher(String ticher) {
        this.ticher = ticher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public Table(int grup, String audit, String leson, String ticher, Date date, int para) {
        this.grup = grup;
        this.audit = audit;
        this.leson = leson;
        this.ticher = ticher;
        this.date = date;
        this.para = para;
    }

}
