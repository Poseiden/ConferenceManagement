package com.tony.biz.impl;

import com.tony.biz.ConferenceBizService;
import com.tony.entity.Session;
import com.tony.entity.SessionType;
import com.tony.entity.Talk;
import com.tony.entity.Track;
import com.tony.util.Tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by ton on 16-4-24.
 */
public class ConferenceBizServiceImpl implements ConferenceBizService{
    private final String  talkConfig ="src/com/tony/config/talks";

    public List<Talk> loadTalkList () throws Exception{
        List<Talk> talkList = new ArrayList<Talk>();

        try {
            File talks = new File(talkConfig);
            BufferedReader reader = new BufferedReader(new FileReader(talks));
            String str = null;
            do{
                str = reader.readLine();
                if(str == null || str.trim().length() == 0) {
                    break;
                }
                Talk talk = Tool.createTalk(str);
                talkList.add(talk);
            }while(true);

        } catch (Exception e) {
            throw new Exception(e);
        }
        return talkList;
    }

    public List<Session> getSessionPerTrack(){
        List<Session> sessionList = new ArrayList<Session>();

        //morningSession
        Calendar start= Calendar.getInstance();
        Calendar end = Calendar.getInstance ();
        start.clear();
        end.clear();
        start.set(Calendar.HOUR_OF_DAY, 9);
        end.set(Calendar.HOUR_OF_DAY,12);

        SessionType sessionType = new SessionType("morningSession",start.getTime(),end.getTime());
        Session morningSession = new Session(sessionType,null,start.getTime());

        //afternoonSession
        start =Calendar.getInstance();
        end = Calendar.getInstance();
        start.clear();
        end.clear();
        start.set(Calendar.HOUR_OF_DAY,13);
        end.set(Calendar.HOUR_OF_DAY,17);

        sessionType = new SessionType("afternoonSession",start.getTime(),end.getTime());
        Session afternoonSession = new Session(sessionType,null,start.getTime());

        sessionList.add(morningSession);
        sessionList.add(afternoonSession);

        return sessionList;
    }

    public List<Track> getTrackAfterTaskScheduled(List<Talk> talkList,List<Session> sessionList){
        
        return null;
    }


}
