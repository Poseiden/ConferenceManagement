package com.tony.util;

import com.tony.entity.Talk;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ton on 16-5-1.
 */
public class ToolTest {


    @Before
    public void setUp() throws Exception {


    }

    @Test(expected = Exception.class)
    public void testCreateTalk() throws Exception {
        String talkStr = "Writing Fast Tests Against Enterprise Rails 60min";
        Talk talk = Tool.createTalk(talkStr);

        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails",talk.getTitleName());
        Assert.assertEquals(60,talk.getLast());
        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails 60min",talk.getFullContent());

        talkStr = "Writing Fast Tests Against Enterprise Rails lightning";
        talk = Tool.createTalk(talkStr);
        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails", talk.getTitleName());
        Assert.assertEquals(5,talk.getLast());
        Assert.assertEquals("Writing Fast Tests Against Enterprise Rails lightning",talk.getFullContent());


        talkStr = "Writing Fast Tests Against Enterprise Rails";
        talk = Tool.createTalk(talkStr);
    }


    @Test
    public void testGetTrackAfterTalkScheduled() throws Exception {

    }
}