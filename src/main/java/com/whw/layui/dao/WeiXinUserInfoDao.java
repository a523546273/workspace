package com.whw.layui.dao;

import com.whw.layui.po.WeiXinUserInfoPo;
import org.springframework.stereotype.Repository;

@Repository
public interface WeiXinUserInfoDao {

    int insert(WeiXinUserInfoPo weiXinUserInfoPo);

    WeiXinUserInfoPo selectByOpenid(String openid);

    void updateByPrimaryKey(WeiXinUserInfoPo weiXinUserInfoPo);
}
