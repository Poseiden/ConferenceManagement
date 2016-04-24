package com.tony.biz;

import com.tony.biz.impl.ConferenceBizServiceImpl;
import com.tony.biz.impl.ScheduleTalkListServiceImpl;
import com.tony.entity.Session;
import com.tony.entity.Talk;
import com.tony.entity.Track;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by ton on 16-4-24.
 */
public class TestScheduleTalkListService {

    private ScheduleTalkListService scheduleTalkListService;

    @Test
    public void testGetTrackAfterTalkScheduled() throws Exception {
        ConferenceBizService conferenceBizService = new ConferenceBizServiceImpl();

        List<Talk> talkList = conferenceBizService.loadTalkList();  //装载所有talklist
        List<Session> sessions = conferenceBizService.getSessionPerTrack(); //获得一个track的sessionList

        Track track = new Track("track01",sessions);
        scheduleTalkListService = new ScheduleTalkListServiceImpl();

        Collections.sort(talkList);

        track = scheduleTalkListService.getTrackAfterTalkScheduled(talkList,track);

        for(Session _session : track.getSessionList()){
            System.out.println(_session.getSessionType().getSessionTypeName());
            for(Talk _talk:_session.getTalkList()){
                System.out.println(_talk.toString());
            }
        }
    }


}
