package com.tony.app;

import com.tony.biz.ConferenceService;
import com.tony.biz.TalkBizService;
import com.tony.biz.impl.ConferenceServiceImpl;
import com.tony.biz.impl.TalkBizServiceImpl;
import com.tony.entity.Conference;
import com.tony.entity.Talk;

import java.util.List;

/**
 * Created by ton on 16-4-24.
 * ConferenceManagement入口类
 */
public class ConferenceCreation {
    private static final String configPath = "src/com/tony/config/talks";

    public static void main(String[] args) throws Exception{
        conferenceCreation();
    }

    public static Conference conferenceCreation()throws Exception{
        TalkBizService talkBizService = new TalkBizServiceImpl();
        ConferenceService conferenceService = new ConferenceServiceImpl();
        List<Talk> talkList = talkBizService.loadTalkList(configPath);//装载所有talk
        Conference conference = conferenceService.createConferecne(talkList); //整个Conference的schedule结束
        return conference;
    }
}
