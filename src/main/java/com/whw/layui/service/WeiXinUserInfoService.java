package com.whw.layui.service;

import com.whw.layui.po.WeiXinUserInfoPo;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/30
 * Time:21:40
 */
public interface WeiXinUserInfoService {
    /**
     * 新增用户信息
     *
     * @param weiXinUserInfoPo
     */
    void add(WeiXinUserInfoPo weiXinUserInfoPo);

    /**
     * 根据openid获取用户信息
     *
     * @param openid
     * @return
     */
    WeiXinUserInfoPo selectByOpenid(String openid);

    /**
     * 用户下载成功后回调  可下载次数减1
     * @param openid
     */
    void downSuccess(String openid) throws Exception;

    /**
     * 用户下载成功后
     * @param openid
     */
    void downShare(String openid);

}
