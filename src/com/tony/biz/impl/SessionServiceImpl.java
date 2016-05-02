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
    public List<Session> createSessionListPerTrack() {
        List<Session> sessionList = new ArrayList<Session>();

        //morningSession
        Calendar start= Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.clear();
        end.clear();
        start.set(Calendar.HOUR_OF_DAY, 9);
        end.set(Calendar.HOUR_OF_DAY,12);

        SessionType sessionType = new SessionType("morningSession",start.getTime(),end.getTime(),true);
        Session morningSession = new Session(sessionType);

        //afternoonSession
        start =Calendar.getInstance();
        end = Calendar.getInstance();
        start.clear();
        end.clear();
        start.set(Calendar.HOUR_OF_DAY,13);
        end.set(Calendar.HOUR_OF_DAY,17);

        sessionType = new SessionType("afternoonSession",start.getTime(),end.getTime(),true);
        Session afternoonSession = new Session(sessionType);

        //lunch session
        start  = Calendar.getInstance();
        end = Calendar.getInstance();
        start.clear();
        end.clear();
        start.set(Calendar.HOUR_OF_DAY,12);
        end.set(Calendar.HOUR_OF_DAY,13);

        sessionType = new SessionType("lunch",start.getTime(),end.getTime(),false);
        Session lunch = new Session(sessionType);

        //network event
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.clear();
        end.clear();
        start.set(Calendar.HOUR_OF_DAY,17);

        sessionType = new SessionType("Networking Event",start.getTime(),false);
        Session networking = new Session(sessionType);

        sessionList.add(morningSession);
        sessionList.add(lunch);
        sessionList.add(afternoonSession);
        sessionList.add(networking);

        return sessionList;
    }
}
