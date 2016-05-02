package com.tony.biz.impl;

import com.tony.biz.TalkBizService;
import com.tony.entity.Talk;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ton on 16-5-2.
 */
public class TalkBizServiceImplTest {
    private TalkBizService talkBizService ;
    private static String configPath = null;

    @Before
    public void setUp() throws Exception {
        this.talkBizService = new TalkBizServiceImpl();
    }

    @Test
    public void loadTalkListWithValidPath()throws Exception{
        configPath = "src/test/com/tony/config/validTalks";
        List<Talk> talkList = talkBizService.loadTalkList(configPath);
        Assert.assertEquals(18,talkList.size());
    }

    @Test
    public void loadTalkListWithNullPath()throws Exception{
        configPath = "src/test/com/tony/config/spaceTalks";
        List<Talk> talkList = talkBizService.loadTalkList(configPath);
        Assert.assertEquals(0,talkList.size());
    }

    @Test(expected=Exception.class)
    public void loadTalkListWithInvalidPath()throws Exception{
        configPath = "src/test/com/tony/config/invalidTalks";
        List<Talk> talkList = talkBizService.loadTalkList(configPath);
    }

}