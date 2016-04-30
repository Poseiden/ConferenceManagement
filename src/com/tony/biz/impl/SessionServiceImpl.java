package com.tony.biz.impl;

import com.tony.biz.SessionService;
import com.tony.entity.Session;
import com.tony.entity.SessionType;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ton on 16-4-30.
 */
public class SessionServiceImpl implements SessionService{

    @Override
    public List<Session> createSessionList() {
        List<Session> sessionList = new ArrayList<Session>();

        //morningSession
        Calendar start= Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.clear();
        end.clear();
        start.set(Calendar.HOUR_OF_DAY, 9);
        end.set(Calendar.HOUR_OF_DAY,12);

        SessionType sessionType = new SessionType("morningSession",start.getTime(),end.getTime(),true);
        Session morningSession = new Session(sessionType,null,start.getTime());

        //afternoonSession
        start =Calendar.getInstance();
        end = Calendar.getInstance();
        start.clear();
        end.clear();
        start.set(Calendar.HOUR_OF_DAY,13);
        end.set(Calendar.HOUR_OF_DAY,17);

        sessionType = new SessionType("afternoonSession",start.getTime(),end.getTime(),true);
        Session afternoonSession = new Session(sessionType,null,start.getTime());

        //lunch session
        start  = Calendar.getInstance();
        end = Calendar.getInstance();
        start.clear();
        end.clear();
        start.set(Calendar.HOUR_OF_DAY,12);

        sessionType = new SessionType("lunch",start.getTime(),null,false);
        Session lunch = new Session(sessionType,null,start.getTime());

        //network event
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.clear();
        end.clear();
        start.set(Calendar.HOUR_OF_DAY,17);

        sessionType = new SessionType("Networking Event",start.getTime(),null,false);
        Session networking = new Session(sessionType,null,start.getTime());

        sessionList.add(morningSession);
        sessionList.add(lunch);
        sessionList.add(afternoonSession);
        sessionList.add(networking);

        return sessionList;
    }
}
