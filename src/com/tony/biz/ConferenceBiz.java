package com.tony.biz;

import com.tony.entity.Session;
import com.tony.entity.SessionType;
import com.tony.entity.Talk;
import com.tony.entity.Track;
import com.tony.util.Tool;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by ton on 16-4-23.
 */
public class ConferenceBiz {
    private final String  talkConfig ="src/com/tony/config/talks";

    /**
     * 根据配置文件装载所有talks
     * @return
     * @throws IOException
     */
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

    /**
     * 每个Track的sessionList
     * @return
     */
    public List<Session> getSessionPerTrack(){
        List<Session> sessionList = new ArrayList<Session>();

        //morningSession
        Calendar start= new GregorianCalendar();
        Calendar end = new GregorianCalendar();
        start.set(Calendar.HOUR_OF_DAY, 9);
        end.set(Calendar.HOUR_OF_DAY,12);

        SessionType sessionType = new SessionType("morningSession",start.getTime(),end.getTime());
        Session morningSession = new Session(sessionType,null,start.getTime());

        //afternoonSession
        start = new GregorianCalendar();
        end = new GregorianCalendar();
        start.set(Calendar.HOUR_OF_DAY,13);
        end.set(Calendar.HOUR_OF_DAY,17);

        sessionType = new SessionType("afternoonSession",start.getTime(),end.getTime());
        Session afternoonSession = new Session(sessionType,null,start.getTime());

        sessionList.add(morningSession);
        sessionList.add(afternoonSession);

        return sessionList;
    }

    /**
     * 将sessionList和talkList传入，schedule之，并组装成track，返回
     * @param talkList 装载好的话题
     * @param sessionList
     * @return
     */
    public Track getTrackAfterTaskScheduled(List<Talk> talkList,List<Session> sessionList){
        return null;
    }


}

