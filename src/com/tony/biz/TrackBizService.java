package com.tony.biz;

import com.tony.entity.Session;
import com.tony.entity.Talk;
import com.tony.entity.Track;

import java.util.List;

/**
 * Created by ton on 16-4-24.
 */
public interface TrackBizService {

    /**
     * 将sessionList和talkList传入，schedule之，并组装成track，返回
     * @param talkList 装载好的talk
     * @return list of track
     */
    List<Track> getTrackAfterTaskScheduled(List<Talk> talkList)throws Exception;
}
