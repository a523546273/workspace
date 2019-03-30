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

}
