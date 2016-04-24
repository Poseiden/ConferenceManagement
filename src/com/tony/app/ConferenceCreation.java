package com.tony.app;

import com.tony.biz.TalkBizService;
import com.tony.biz.TrackBizService;
import com.tony.biz.impl.TalkBizServiceImpl;
import com.tony.biz.impl.TrackBizServiceImpl;
import com.tony.entity.Conference;
import com.tony.entity.Session;
import com.tony.entity.Talk;
import com.tony.entity.Track;

import java.util.List;

/**
 * Created by ton on 16-4-24.
 * ConferenceManagement入口类
 */
public class ConferenceCreation {
    private static final String configPath = "src/com/tony/config/talks";

    public static void main(String[] args) throws Exception{
        TalkBizService talkBizService = new TalkBizServiceImpl();
        TrackBizService trackBizService = new TrackBizServiceImpl();

        List<Talk> talkList = talkBizService.loadTalkList(configPath);//装载所有talk
        List<Track> trackList = trackBizService.getTrackAfterTaskScheduled(talkList);  //schedule之后的trackList

        Conference conference = new Conference(trackList); //整个Conference的schedule结束

        //结果输出
        List<Track> tracks = conference.getTrackList();
        for(Track _track:tracks){
            System.out.println(_track.toString());
            List<Session> sessionList = _track.getSessionList();
            for(Session _session : sessionList){
                if(!_session.getSessionType().isScheduleable()){
                    System.out.println(_session.toString());
                }else{
                    List<Talk> talks = _session.getTalkList();
                    for(Talk _talk : talks){
                        System.out.println(_talk.toString());
                    }
                }
            }
        }
    }
}
