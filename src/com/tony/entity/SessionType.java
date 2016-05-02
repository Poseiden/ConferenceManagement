package com.tony.entity;

import java.util.Date;

/**
 * Created by ton on 16-4-23.
 */
public class SessionType{

    private String sessionTypeName;
    private Date start; //此session起始时间
    private Date end; //此session的结束时间
    private boolean scheduleable;   //可否被schedule，因为后期把lunch和networking也看做sessiontype的一种，所以对于这两个来说就是不可schedule的

    public String getSessionTypeName() {
        return sessionTypeName;
    }

    public void setSessionTypeName(String sessionTypeName) {
        this.sessionTypeName = sessionTypeName;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isScheduleable() {
        return scheduleable;
    }

    public void setScheduleable(boolean scheduleable) {
        this.scheduleable = scheduleable;
    }

    /****************Constructor*********/
    public SessionType() {
    }

    public SessionType(String sessionTypeName,Date start,Date end,boolean scheduleable) {
        this.sessionTypeName = sessionTypeName;
        this.start = start;
        this.end = end;
        this.scheduleable = scheduleable;
    }

    public SessionType(String sessionTypeName,Date start,boolean scheduleable) {
        this.sessionTypeName = sessionTypeName;
        this.start = start;
        this.scheduleable = scheduleable;
    }
}
