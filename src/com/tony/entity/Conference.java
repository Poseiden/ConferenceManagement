package com.tony.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ton on 16-4-23.
 */
public class Conference implements Serializable{
    private static final long serialVersionUID = 4418732194481868879L;
    private String conferenceId;
    private List<Track> trackList;

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    /*********Constructor***********/
    public Conference() {
    }

    public Conference(List<Track> trackList) {
        this.trackList = trackList;
    }
}
