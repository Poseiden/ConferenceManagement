package com.tony.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by ton on 16-4-23.
 */
public class Talk implements Serializable ,Comparable<Talk>{

    private static final long serialVersionUID = -3690186227705969683L;
    private String titleName;
    private int last;//持续时间
    private Date start;   //起始时间
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

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setIsScheduled(boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    /**************Constructor************/
    public Talk() {
    }

    public Talk(String titleName, int last) {
        this.titleName = titleName;
        this.last = last;
    }

    public Talk(String titleName, int last,Date start,boolean isScheduled) {
        this.titleName = titleName;
        this.last = last;
        this.start = start;
        this.isScheduled = isScheduled;
    }

    /**********Duplicate*************/

    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("hh:mm");
        return String.format("start:%s\t titleName:%s\t last:%s",format.format(this.getStart()),this.getTitleName(),this.getLast());
    }
//
//    @Override
//    public int compare(Talk o1, Talk o2) {
//        int difference = o1.getLast() - o2.getLast();
//        if(difference > 0){
//            return 1;
//        }else if(difference < 0){
//            return -1;
//        }else{
//            return 0;
//        }
//    }

    @Override
    public int compareTo(Talk o) {
        int difference = this.getLast() - o.getLast();

        if(difference > 0){
            return 1;
        }else if(difference < 0){
            return -1;
        }else{
            return 0;
        }
    }
}
