package com.tony.biz;

import com.tony.entity.Talk;

import java.util.List;

/**
 * Created by ton on 16-4-24.
 */
public interface TalkBizService {

    /**
     * 按照配置文件装载Talk
     * @param talkConfigPath talk配置文件的路径
     * @return List of Talk list of talk object
     * @throws Exception
     */
    List<Talk> loadTalkList (String talkConfigPath) throws Exception;
}
