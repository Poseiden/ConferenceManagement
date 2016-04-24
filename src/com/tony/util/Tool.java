package com.tony.util;


import com.tony.entity.Talk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 * Created by ton on 16-4-23.
 */
public class Tool {
    private static final String regxLetter = "[a-zA-Z]+";
    private static final String regxLightning = "lightning";
    private static final String regxNum = "[0-9]";

    /**
     * 根据传入的字符串来拆分并且创建talk
     * @param str 根据配置文件读入的字符串
     * @return 组装的talk
     */
    public static Talk createTalk(String str) throws Exception{
        String titleName = str.substring(0, str.lastIndexOf(" "));  //拆分titlename
        String last = str.substring(str.lastIndexOf(" ") + 1);   //将时间那个字段拆出来
        int last_int = 0;

        Pattern p = Pattern.compile(regxNum);
        Matcher m = p.matcher(last);

        if (m.find()) {//先判断是否含有数字，否则就是“lightning”
            p = Pattern.compile(regxLetter);
            m = p.matcher(last);
            last_int = Integer.parseInt(m.replaceAll("").trim());   //将min过滤掉，然后提取出其中的数字
        } else {
            p = Pattern.compile(regxLightning);
            m = p.matcher(last);
            if (m.find()) {
                last_int = 5; //将last置为lightning
            }else{
                throw new Exception("Invalid Duration");
            }
        }

        Talk talk = new Talk(titleName,last_int);
        return talk;
    }
}
