package com.whw.layui.controller;

import com.alibaba.fastjson.JSONObject;
import com.whw.layui.config.RedisConfig;
import com.whw.layui.enums.ResultEnums;
import com.whw.layui.po.WeiXinUserInfoPo;
import com.whw.layui.service.AttendanceService;
import com.whw.layui.service.WeiXinUserInfoService;
import com.whw.layui.utils.CodeUtils;
import com.whw.layui.utils.HttpClientUtil;
import com.whw.layui.utils.ResponseData;
import com.whw.layui.utils.ResponseDataUtil;
import com.whw.layui.vo.rsp.WeiXinInfoRsp;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/30
 * Time:11:31
 */
@RestController
public class WxLoginController {

    private static final String WXURL = "https://api.weixin.qq.com/sns/jscode2session";

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    @Value("${wx.grant-type}")
    private String grantType;

    @Value("${wx.subscribe}")
    private Integer subscribe;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private WeiXinUserInfoService weiXinUserInfoService;

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/login/wxLogin")
    public ResponseData<WeiXinInfoRsp> wxLogin(String code, String shareOpenid) {

        //String wxUrl = "?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        if (StringUtils.isBlank(code)) {
            ResponseDataUtil.buildError(ResultEnums.PARAM_ERROR);
        }
        Map<String, String> map = new HashMap<>();
        map.put("appid", appid);
        map.put("secret", secret);
        map.put("js_code", code);
        map.put("grant_type", grantType);
        String json = HttpClientUtil.doGet(WXURL, map);

        System.out.println(json);
        WeiXinInfoRsp weiXinInfoRsp = JSONObject.parseObject(json, WeiXinInfoRsp.class);

        //存入session到redis

        // redisConfig.set("user-redis-session:" + wxSessionPo.getOpenid(), wxSessionPo.getSession_key(), 1000L * 60 * 30);

        if (weiXinInfoRsp != null) {
            try {
                WeiXinUserInfoPo weiXinUserInfoPo = new WeiXinUserInfoPo();
                weiXinUserInfoPo.setOpenid(weiXinInfoRsp.getOpenid());
                weiXinUserInfoPo.setSessionKey(weiXinInfoRsp.getSession_key());
                //默认只有20次
                weiXinUserInfoPo.setSubscribe(subscribe);

                weiXinUserInfoService.add(weiXinUserInfoPo);

                //获取用户可以再次下载的次数
                WeiXinUserInfoPo result = weiXinUserInfoService.selectByOpenid(weiXinInfoRsp.getOpenid());
                weiXinInfoRsp.setSubscribe(result.getSubscribe());
                weiXinInfoRsp.setInviteCode(result.getInviteCode());
                //获取用户签到次数
                int count = attendanceService.selectCount(weiXinInfoRsp.getOpenid());
                weiXinInfoRsp.setCount(count);

                if (StringUtils.isNotBlank(shareOpenid)) {
                    WeiXinUserInfoPo owner = weiXinUserInfoService.selectByOpenid(shareOpenid);
                    if (owner != null) {
                        int num = owner.getGroupid() + 1;
                        if (num < 5) {
                            owner.setGroupid(num);
                            weiXinUserInfoService.update(owner);
                        } else if (num == 5) {
                            owner.setSubscribe(owner.getSubscribe() + 15);
                            weiXinUserInfoService.update(owner);
                        } else {

                        }
                    }
                }


                return ResponseDataUtil.buildSuccess(weiXinInfoRsp);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
            }
        } else {
            return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
        }

    }

    @PostMapping("/selectByOpenid/{openid}")
    public ResponseData<WeiXinUserInfoPo> selectByOpenid(@PathVariable("openid") String openid) {

        WeiXinUserInfoPo weiXinUserInfoPo = weiXinUserInfoService.selectByOpenid(openid);
        if (weiXinUserInfoPo == null) {
            return ResponseDataUtil.buildError(ResultEnums.NULL_USER);
        } else {
            return ResponseDataUtil.buildSuccess();
        }
    }
}
