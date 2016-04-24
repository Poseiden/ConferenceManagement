package com.tony.biz;

import com.tony.biz.impl.TalkBizServiceImpl;
import com.tony.biz.impl.TrackBizServiceImpl;
import com.tony.entity.Session;
import com.tony.entity.Talk;
import com.tony.entity.Track;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ton on 16-4-25.
 */
public class TestTrackBizService {
   private TalkBizService talkBizService = null;
    private TrackBizService trackBizService = null;
    private static final String talkConfig = "src/com/tony/config/talks";

    @Before
    public void init(){
        this.talkBizService = new TalkBizServiceImpl();
        this.trackBizService = new TrackBizServiceImpl();
    }

    @Test
    public void testGetTrackAfterTaskScheduled()throws Exception{
       List<Talk> talkList = talkBizService.loadTalkList(talkConfig);
        List<Track> tracks = trackBizService.getTrackAfterTaskScheduled(talkList);

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
