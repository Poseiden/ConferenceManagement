package com.tony.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ton on 16-4-23.
 */
public class Session implements Serializable {
    private static final long serialVersionUID = -6360145985701970153L;
    private String sessionId;
    private SessionType sessionType;//session的类型，包括是上午session还是下午session
    private List<Talk> talkList;
    private Date rightNow;//目前排到的时间

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

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

    public Session() {
    }

    /************Duplicate Method*************/
    @Override
    public String toString() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rightNow);
        return String.format("sessionType: %s\t size of talkList : %s\t right now: %s",this.getSessionType().getSessionTypeName(),
                this.getTalkList() == null ? null:this.getTalkList().size(), calendar.get(Calendar.HOUR_OF_DAY)
                );
    }

    /*************method****************/
    /**
     * 获得此session中还有多少分钟可以安排
     * @return 获得分钟数
     */
    public int getRemainingTimeOfMinutes(){
        int minutes  = (int)(this.getSessionType().getEnd().getTime() - this.getRightNow().getTime())/1000/60;
        return minutes;
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
