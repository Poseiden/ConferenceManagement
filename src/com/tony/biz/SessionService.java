package com.tony.biz;

import com.tony.entity.Session;

import java.util.List;

/**
 * Created by ton on 16-4-30.
 */
public interface SessionService {

    /**
     * 创建每个Track所需要的SessionList
     * @return A list of Session
     */
    List<Session> createSessionList();
}
