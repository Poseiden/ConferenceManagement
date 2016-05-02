package com.tony.biz.impl;

import com.tony.biz.ConferenceService;
import com.tony.entity.Conference;
import com.tony.entity.Talk;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ton on 16-5-2.
 */
public class ConferenceServiceImplTest {
    private List<Talk> talksList;
    private ConferenceService conferenceService;

    @Before
    public void setUp() throws Exception {
        talksList = new ArrayList<Talk>();
        Talk talk13 = new Talk("n",180,"n 180min",false);
        Talk talk10 = new Talk("k",150,"k 150min",false);
        Talk talk14 = new Talk("o",120,"o 120mi",false);
        Talk talk3 = new Talk("d",120,"d 120min",false);
        Talk talk5 = new Talk("f",100,"f 100min",false);
        Talk talk6 = new Talk("g",100,"g 100min",false);
        Talk talk9 = new Talk("j",80,"j 80min",false);
        Talk talk4 = new Talk("e",75,"e 75min", false);
        Talk talk2 = new Talk("c",65,"c 65min",false);
        Talk talk12 = new Talk("m",60,"m 60min",false);
        Talk talk8 = new Talk("i",60,"i 60min",false);
        Talk talk1 = new Talk("b",50,"b 50min",false);
        Talk talk = new Talk("a",30,"a 30min",false);
        Talk talk15 = new Talk("p",30,"p 30min",false);
        Talk talk16 = new Talk("q",30,"q 30min",false);
        Talk talk7 = new Talk("h",5,"h 5min",false);
        Talk talk11 = new Talk("l",5,"l 5min",false);

        talksList.add(talk13);
        talksList.add(talk10);
        talksList.add(talk14);
        talksList.add(talk3);
        talksList.add(talk5);
        talksList.add(talk6);
        talksList.add(talk9);
        talksList.add(talk4);
        talksList.add(talk2);
        talksList.add(talk12);
        talksList.add(talk8);
        talksList.add(talk1);
        talksList.add(talk);
        talksList.add(talk15);
        talksList.add(talk16);
        talksList.add(talk7);
        talksList.add(talk11);

        conferenceService = new ConferenceServiceImpl();

    }

    @Test
    public void createConferenceTest()throws Exception{
        Conference conference = conferenceService.createConferecne(talksList);
        Assert.assertEquals(4,conference.getTrackList().size());
    }

    @Test(expected = Exception.class)
    public void createConferenceWithNullTalks()throws Exception{
        Conference conference = conferenceService.createConferecne(null);
    }

}