package com.tony.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ton on 16-4-23.
 */
public class SessionType implements Serializable
{
    private static final long serialVersionUID = 8169551722485706551L;
    private String sessionTypeName;
    private Date start; //此session起始时间
    private Date end;//此session结束时间

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

    /****************Constructor*********/
    public SessionType() {

    }

    public SessionType(String sessionTypeName,Date start, Date end) {
        this.sessionTypeName = sessionTypeName;
        this.start = start;
        this.end = end;
    }
}
