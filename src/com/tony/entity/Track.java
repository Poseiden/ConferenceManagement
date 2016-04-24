package com.tony.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ton on 16-4-23.
 */
public class Track implements Serializable{
    private static final long serialVersionUID = 1314768182424545465L;
    private String trackName;
    private List<Session> sessionList;

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

    /*********Constructor**********/
    public Track() {
    }

    public Track(List<Session> sessionList) {
        this.sessionList = sessionList;
    }
}
