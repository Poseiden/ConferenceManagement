package com.tony.biz;

import com.tony.biz.impl.ConferenceBizServiceImpl;
import com.tony.entity.Conference;
import com.tony.entity.Session;
import com.tony.entity.Talk;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by ton on 16-4-24.
 */
public class TestConferenceBiz {
    private ConferenceBizService conferenceBiz = null;

    /**
     * 测试装载TalkList
     * @throws Exception
     */
    public void testLoadTalkList()throws Exception{
        conferenceBiz = new ConferenceBizServiceImpl();
        List<Talk> talkList = conferenceBiz.loadTalkList();
        for(Talk talk : talkList){
            System.out.println(talk.toString());
        }
    }

    @Test
    /**
     * 测试为每个Track组装session
     */
    public void testGetSessionPerTrack(){
       conferenceBiz = new ConferenceBizServiceImpl();
        List<Session> session = conferenceBiz.getSessionPerTrack();

        for(Session _session : session){
            System.out.println(_session.toString());
        }
    }
}
