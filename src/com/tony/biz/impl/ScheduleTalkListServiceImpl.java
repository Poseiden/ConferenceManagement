package com.tony.biz.impl;

import com.tony.biz.ScheduleTalkListService;
import com.tony.entity.Session;
import com.tony.entity.Talk;
import com.tony.entity.Track;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ton on 16-4-24.
 * 核心算法实现类
 */
public class ScheduleTalkListServiceImpl implements ScheduleTalkListService{


    @Override
    public Track getTrackAfterTalkScheduled(List<Talk> talkList, Track track) {
        List<Session> sessions = track.getSessionList();
        List<Talk> talksOfPerSession = null;

        //是否用尽了session的时间
        boolean runOutOfSessionTime = false;
        //session中的剩余的时间
        int remainingMinutes = 0;

        for(Session _session: sessions){
            talksOfPerSession = new ArrayList<Talk>();//初始化session中的talk集合
           for(Talk _talk : talkList){
               if(_talk.isScheduled()){//是否已经被计划过了
                   continue;
               }
               remainingMinutes = _session.getRemainingTimeOfMinutes();//检查session还剩多少时间

               //如果时间没了，那么跳出，循环下一个session
               if(remainingMinutes == 0){
                   runOutOfSessionTime = true;
                   break;
               }

               //如果这个talk的持续时间在session的剩余时间范围之内,那么安排在此session中
               if(_talk.getLast() <= remainingMinutes ){
                   _talk.setIsScheduled(true);//设置已被schedule过的标志
                  _talk.setStart(_session.getRightNow());//根据session现在时间设置talk开始的时间
                   _session.rightNowAfterScheduled(_talk.getLast());//session时间相应的减去

                   talksOfPerSession.add(_talk);        //talk加进集合中去
               }
           }

            _session.setTalkList(talksOfPerSession);

            if(runOutOfSessionTime){
                continue;
            }
        }

        track.setSessionList(sessions);
        return track;
    }
}
