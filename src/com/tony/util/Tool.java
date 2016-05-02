package com.tony.util;


import com.tony.entity.Talk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类(拆分talkStr以及装入talklist的算法)
 * Created by ton on 16-4-23.
 */
public class Tool {
    private static final String regxLightning = "lightning";
    private static final String regxNum = "\\d{2}";

    /**
     * 根据传入的字符串来拆分并且创建talk
     * @param str 根据配置文件读入的字符串
     * @return 组装的talk
     */
    public static Talk createTalk(String str) throws Exception{
        int duration_int = 0;

        Pattern pattern = Pattern.compile(regxNum);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {//先判断是否含有数字，否则就是“lightning”
            duration_int = Integer.parseInt(matcher.group());
        } else {
            pattern = Pattern.compile(regxLightning);
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                duration_int = 5; //将last置为lightning
            }else{
                throw new Exception("Invalid Duration");
            }
        }
        String titleName = str.substring(0, str.lastIndexOf(" "));  //拆分titlename

        Talk talk = new Talk(titleName,duration_int,str,false);
        return talk;
    }
}
