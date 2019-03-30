package com.whw.layui.utils;

import com.alibaba.fastjson.JSONObject;
import com.whw.layui.po.WeiXinUserInfoPo;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/30
 * Time:11:48
 */
public class WeiXinUserInfoUtils {

    private final static String WECHAT_USER_INFO_URL = "ttps://api.weixin.qq.com/cgi-bin/user/info"; //?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN

    /**
     * 获取微信用户基本信息
     *
     * @param accessToken
     * @param openid
     * @return
     */
    public WeiXinUserInfoPo getUserInfo(String accessToken, String openid) {
        WeiXinUserInfoPo weixinUserInfo = null;
        Map<String, String> map = new TreeMap<String, String>();
        map.put("access_token", accessToken);
        map.put("openid", openid);
        String result = HttpClientUtil.doPost(WECHAT_USER_INFO_URL, map);
        try {
            weixinUserInfo = JSONObject.parseObject(result, WeiXinUserInfoPo.class);
        } catch (Exception e) {
            weixinUserInfo = null;
        }
        return weixinUserInfo;

    }
}
