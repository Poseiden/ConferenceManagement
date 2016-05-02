package com.tony.util;


import com.tony.biz.TalkBizService;
import com.tony.biz.impl.TalkBizServiceImpl;
import com.tony.entity.Talk;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ton on 16-5-1.
 */
public class ToolTest {
    TalkBizService talkBizService = null;

    @Before
    public void setUp() throws Exception {
        talkBizService = new TalkBizServiceImpl();
    }

    @Test
    public void createTalkLightningWithinStr() throws Exception {
        String talkStr = "Writing Fast Tests Against Enterprise Rails lightning";
        Talk talk = Tool.createTalk(talkStr);
        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails", talk.getTitleName());
        Assert.assertEquals(5,talk.getLast());
        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails lightning",talk.getFullContent());
    }

    @Test
    public void createTalkNumberWithinStr() throws Exception {
        String talkStr = "Writing Fast Tests Against Enterprise Rails 60min";
        Talk talk = Tool.createTalk(talkStr);

        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails",talk.getTitleName());
        Assert.assertEquals(60,talk.getLast());
        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails 60min",talk.getFullContent());
    }

    @Test(expected = Exception.class)
    public void createTalkInvalidDuration() throws Exception {
        String talkStr = "Writing Fast Tests Against Enterprise Rails";
        Talk talk = Tool.createTalk(talkStr);
    }
}