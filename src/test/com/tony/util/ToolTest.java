package com.tony.util;


import com.tony.biz.TalkBizService;
import com.tony.biz.TrackBizService;
import com.tony.biz.impl.TalkBizServiceImpl;
import com.tony.biz.impl.TrackBizServiceImpl;
import com.tony.entity.Session;
import com.tony.entity.SessionType;
import com.tony.entity.Talk;
import com.tony.entity.Track;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ton on 16-5-1.
 */
public class ToolTest {
    TrackBizService trackBizService = null;
    TalkBizService talkBizService = null;

    @Before
    public void setUp() throws Exception {
        trackBizService = new TrackBizServiceImpl();
        talkBizService = new TalkBizServiceImpl();
    }

    @Test
    public void createTalkLightningWithinStr() throws Exception {
        String talkStr = "Writing Fast Tests Against Enterprise Rails lightning";
        Talk talk = Tool.createTalk(talkStr);
        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails", talk.getTitleName());
        Assert.assertEquals(5,talk.getLast());
        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails lightning",talk.getFullContent());
    }

    @Test
    public void createTalkNumberWithinStr() throws Exception {
        String talkStr = "Writing Fast Tests Against Enterprise Rails 60min";
        Talk talk = Tool.createTalk(talkStr);

        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails",talk.getTitleName());
        Assert.assertEquals(60,talk.getLast());
        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails 60min",talk.getFullContent());
    }

    @Test(expected = Exception.class)
    public void createTalkInvalidDuration() throws Exception {
        String talkStr = "Writing Fast Tests Against Enterprise Rails";
        Talk talk = Tool.createTalk(talkStr);
    }

    @Test
    public void scheduleTalkListToTrack()throws Exception{
        Talk talk1 = new Talk("aabb",100,"aabb 100min",false);
        Talk talk2 = new Talk("ccdd",150,"ccdd 150min",false);
        Talk talk3 = new Talk("eeff",200,"eeff 200min",false);
        List<Talk> talkList = new ArrayList<Talk>();
        talkList.add(talk1);
        talkList.add(talk2);
        talkList.add(talk3);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,9);
        Date start = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY,12);
        Date end = calendar.getTime();
        SessionType sessionType  = new SessionType("morningSession",start,end,true);
        Session session = new Session(sessionType,start);

        List<Session> sessionList = new ArrayList<Session>();
        sessionList.add(session);
        Track track = new Track("track-01",sessionList);

        track = Tool.getTrackAfterTalkScheduled(talkList,track);

    }
}