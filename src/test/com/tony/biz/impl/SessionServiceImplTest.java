package com.tony.biz.impl;

import com.tony.biz.SessionService;
import com.tony.entity.Session;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ton on 16-5-2.
 */
public class SessionServiceImplTest {
    private SessionService sessionService;
    @Before
    public void setUp() throws Exception {
        sessionService = new SessionServiceImpl();
    }

    @Test
    public void createSessionListPerTrack() throws Exception {
        List<Session> sessionList = sessionService.createSessionListPerTrack();
        Assert.assertEquals(4,sessionList.size());
    }
}