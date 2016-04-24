package com.tony.biz;

import com.tony.biz.impl.TalkBizServiceImpl;
import com.tony.entity.Talk;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ton on 16-4-25.
 */
public class TestTalkBizService {
    private TalkBizService talkBizService = null;
    private static final String talkConfig = "src/com/tony/config/talks";

    @Before
    public void init(){
        talkBizService = new TalkBizServiceImpl();
    }

    @Test
    public void testLoadTalkList() throws Exception{
       List<Talk> talkList = this.talkBizService.loadTalkList(talkConfig);

        for(Talk _talk: talkList){
            System.out.println(_talk.toString());
        }
    }
}
