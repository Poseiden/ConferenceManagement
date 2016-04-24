package com.tony.biz;

import com.tony.entity.Session;
import com.tony.entity.Talk;
import com.tony.entity.Track;

import java.util.List;

/**
 * Created by ton on 16-4-24.
 * 核心算法Schedule接口
 */
public interface ScheduleTalkListService {

    Track getTrackAfterTalkScheduled(List<Talk> talkList,Track track);
}
