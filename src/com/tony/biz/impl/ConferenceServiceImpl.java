package com.tony.biz.impl;

import com.tony.biz.ConferenceService;
import com.tony.biz.SessionService;
import com.tony.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ton on 16-5-1.
 */
public class ConferenceServiceImpl implements ConferenceService{
    private SessionService sessionService = new SessionServiceImpl();

    @Override
    public Conference createConferecne(List<Talk> talksToBeScheduled) throws Exception {
        Conference conference  = new Conference();
        List<Track> tracks = new ArrayList<Track>();

        Track track = null;

        int trackIndex = 0;
        List<Session> sessionList = null;
        while(!this.areAllTalksScheduled(talksToBeScheduled)){
            track = new Track();
            trackIndex++;
            sessionList  = sessionService.createSessionListPerTrack();//To create new sessionList per track
            track.setTrackName(String.format("Track-%s",trackIndex));

            for(Session _session:sessionList){
                List<Talk> talkList = null;
                if(_session.getSessionType().isScheduleable()){
                    talkList = new ArrayList<Talk>();
                    for(Talk _talk:talksToBeScheduled){
                        if(_session.getRemainingTimeOfMinutes() == 0){//如果剩余时间为0，那么遍历下一个session
                            break;
                        }
                        if(_talk.isScheduled()){
                            continue;
                        }
                        if(_talk.getLast() <= _session.getRemainingTimeOfMinutes()){
                            talkList.add(_talk);
                            _talk.setIsScheduled(true);
                            _session.rightNowAfterScheduled(_talk.getLast());
                        }
                    }
                    _session.setTalkList(talkList);
                }else{
                    continue;
                }
            }
            track.setSessionList(sessionList);
            tracks.add(track);
        }
        conference.setTrackList(tracks);
        return conference;
    }

    /**
     * 判断是否全部的talk都被schedule过
     * @param talks
     * @return 是：true 否：false
     * @throws Exception 如果传入的talks为空
     */
    private boolean areAllTalksScheduled(List<Talk> talks) throws Exception {
        if(talks == null || talks.size() == 0){
            throw new Exception("Talks which to be scheduled is null");
        }
        for(Talk _talk:talks){
            if(!_talk.isScheduled()){
                return false;
            }
        }
        return true;
    }
}
