package com.tony.entity;

import java.io.Serializable;

/**
 * Created by ton on 16-4-23.
 */
public class Talk implements Serializable {

    private static final long serialVersionUID = -3690186227705969683L;
    private String titleName;
    private int last;//持续时间
    private String start;   //起始时间
    private boolean isScheduled = false;//是否已经被排过

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public String getStart() {
        return start;
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setIsScheduled(boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

    public void setStart(String start) {
        this.start = start;
    }

    /**************Constructor************/
    public Talk() {
    }

    public Talk(String titleName, int last) {
        this.titleName = titleName;
        this.last = last;
    }

    public Talk(String titleName, int last,String start,boolean isScheduled) {
        this.titleName = titleName;
        this.last = last;
        this.start = start;
        this.isScheduled = isScheduled;
    }

    @Override
    public String toString() {
        return String.format("titleName:%s;last:%s",this.getTitleName(),this.getLast());
    }
}
