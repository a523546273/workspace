package com.whw.layui.vo;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/30
 * Time:17:01
 */
public class OpenidVo {

    private String session_key;

    private String openid;

    private Integer subscribe;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }
}
