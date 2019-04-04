package com.whw.layui.vo.rsp;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/31
 * Time:21:02
 */
public class WeiXinInfoRsp {

    private String session_key;

    private String openid;

    private Integer subscribe;

    private int count;

    private String inviteCode;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
