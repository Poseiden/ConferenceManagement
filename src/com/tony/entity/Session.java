package com.tony.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ton on 16-4-23.
 * session
 */
public class Session {
    private SessionType sessionType;//session的类型
    private List<Talk> talkList;
    private Date rightNow;//目前排到的时间

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public List<Talk> getTalkList() {
        return talkList;
    }

    public void setTalkList(List<Talk> talkList) {
        this.talkList = talkList;
    }

    public Date getRightNow() {
        return rightNow;
    }

    public void setRightNow(Date rightNow) {
        this.rightNow = rightNow;
    }

    /************Constructor*************/
    public Session(SessionType sessionType, List<Talk> talkList, Date rightNow) {
        this.sessionType = sessionType;
        this.talkList = talkList;
        this.rightNow = rightNow;
    }

    public Session(SessionType sessionType , Date rightNow){
        this.sessionType = sessionType;
        this.rightNow = rightNow;
    }

    public Session() {
    }

    /************Duplicate Method*************/
    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mma");
        return String.format("%s\t %s",dateFormat.format(this.getRightNow()),this.getSessionType().getSessionTypeName());
    }

    /*************method****************/
    /**
     * 获得此session中还剩多少分钟可以安排
     * @return 获得分钟数
     */
    public int getRemainingTimeOfMinutes()throws Exception{
        if(this.getSessionType().isScheduleable()) {
            int minutes = (int) (this.getSessionType().getEnd().getTime() - this.getRightNow().getTime()) / 1000 / 60;
            return minutes;
        }else{
            throw new Exception("No Avaliable for schedule");
        }
    }

    /**
     * 算出并设置在安排完一个talk后session的的当前时间指向
     * @param talkLastMinutes 一个talk的持续分钟数
     */
    public void rightNowAfterScheduled(int talkLastMinutes){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.getRightNow());
        calendar.add(Calendar.MINUTE,talkLastMinutes);
        this.setRightNow(calendar.getTime());
    }
}
