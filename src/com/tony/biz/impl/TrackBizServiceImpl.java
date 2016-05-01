package com.tony.biz.impl;

import com.tony.biz.SessionService;
import com.tony.biz.TrackBizService;
import com.tony.entity.Session;
import com.tony.entity.Talk;
import com.tony.entity.Track;
import com.tony.util.Tool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ton on 16-4-24.
 */
public class TrackBizServiceImpl implements TrackBizService {
    private SessionService sessionService = null;

    public List<Track> getTrackAfterTaskScheduled(List<Talk> talkList )throws Exception{
        sessionService = new SessionServiceImpl();
        List<Session> sessionList = null;
        List<Track> trackList = new ArrayList<Track>();

        Track track = null;
        int _index = 0;

        while(!ifAllTalkListScheduled(talkList)){ //只要有talk还没有被schedule，那就继续循环
            _index ++;
            sessionList = sessionService.createSessionList(); //初始化sessionList
            track = new Track(String.format("Track %s:",String.valueOf(_index)),sessionList);
            track = Tool.getTrackAfterTalkScheduled(talkList,track); //核心schedule方法

            trackList.add(track);
        }
        return trackList;
    }

    /**
     * 是否全部的talkList都被schedule过了
     * @param talkList 待schedule的talkList
     * @return 全部schedule?true:false
     */
    private boolean ifAllTalkListScheduled(List<Talk> talkList){
       for(Talk _talk:talkList){
           if(!_talk.isScheduled()){
               return false;
           }
       }
        return true;
    }
}
