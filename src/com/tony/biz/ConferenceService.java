package com.tony.biz;

import com.tony.entity.Conference;
import com.tony.entity.Talk;

import java.util.List;

/**
 * Created by ton on 16-5-1.
 */
public interface ConferenceService {
    /**
     * 创建Conference
     * @param talksToBeScheduled 待schedule的talks
     * @return Conference
     */
    Conference createConferecne(List<Talk> talksToBeScheduled) throws Exception;
}
