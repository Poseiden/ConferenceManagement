package com.tony.biz.impl;

import com.tony.biz.TalkBizService;
import com.tony.entity.Talk;
import com.tony.util.Tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ton on 16-4-24.
 */
public class TalkBizServiceImpl implements TalkBizService {

    public List<Talk> loadTalkList (String talkConfigPath) throws Exception{
        List<Talk> talkList = new ArrayList<Talk>();

        try {
            File talks = new File(talkConfigPath);
            BufferedReader reader = new BufferedReader(new FileReader(talks));
            String str = null;
            Talk talk = null;
            do{
                str = reader.readLine();
                if(str == null || str.trim().length() == 0) {
                    break;
                }
                talk = Tool.createTalk(str);
                talkList.add(talk);
            }while(true);

        } catch (Exception e) {
            throw new Exception(e);
        }

//        Collections.sort(talkList);
        Collections.sort(talkList, Collections.reverseOrder());//反向排序，把时间长的放前面
        return talkList;
    }
}
