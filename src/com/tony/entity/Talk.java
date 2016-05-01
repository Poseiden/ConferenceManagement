package com.tony.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ton on 16-4-23.
 * 演讲，交流
 */
public class Talk implements Comparable<Talk>{

    private String titleName;
    private int last;//持续时间
    private Date start;   //起始时间
    private boolean isScheduled = false;//是否已经被排过
    private String fullContent; //配置文件中的原始字符串

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

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    /**************Constructor************/
    public Talk() {
    }

    public Talk(String titleName, int last,String fullContent,boolean isScheduled) {
        this.titleName = titleName;
        this.last = last;
        this.fullContent = fullContent;
        this.isScheduled = isScheduled;
    }

    /**********Duplicate*************/

    @Override
    public String toString() {
        if(this.getStart() == null){
            return this.getFullContent();
        }
        DateFormat format = new SimpleDateFormat("hh:mma");
        return String.format("%s\t %s",format.format(this.getStart()),this.getFullContent());
    }

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
