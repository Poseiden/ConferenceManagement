package com.tony.app;

import com.tony.biz.ConferenceBiz;
import com.tony.entity.Session;
import com.tony.entity.Talk;

import java.util.List;

/**
 * Created by ton on 16-4-24.
 * ConferenceManagement入口类
 */
public class ConferenceCreation {
    public static void main(String[] args) throws Exception{
        ConferenceBiz conferenceBiz = new ConferenceBiz();
        List<Talk> talkList = conferenceBiz.loadTalkList();//装载所有talk

        List<Session> sessionList = conferenceBiz.getSessionPerTrack();


    }
}
