package com.tony.util;

import com.tony.entity.Session;
import com.tony.entity.Talk;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ton on 16-4-25.
 */
public class TestTool {
    private static final String talkStr = "Writing Fast Tests Against Enterprise Rails 60min";

    public void testCreateTalk()throws Exception{
        Talk talk = Tool.createTalk(talkStr);
        System.out.println(talk.toString());
    }

    @Test
    public void testGetSessionPerTrack(){
        List<Session> sessionList = Tool.getSessionPerTrack();
        for(Session _session: sessionList){
            System.out.println(_session.toString());
        }
    }
}
