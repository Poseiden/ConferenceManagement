package com.tony.biz;

import com.tony.entity.Session;
import com.tony.entity.Talk;
import com.tony.entity.Track;

import java.util.List;

/**
 * Created by ton on 16-4-24.
 */
public interface ConferenceBizService {

    /**
     * 根据配置文件装载所有talks
     * @return
     * @throws Exception
     */
    List<Talk> loadTalkList () throws Exception;

    /**
     * 每个Track的sessionList
     * @return
     */
    List<Session> getSessionPerTrack();

    /**
     * 将sessionList和talkList传入，schedule之，并组装成track，返回
     * @param talkList 装载好的话题
     * @param sessionList
     * @return
     */
    List<Track> getTrackAfterTaskScheduled(List<Talk> talkList,List<Session> sessionList);
}
