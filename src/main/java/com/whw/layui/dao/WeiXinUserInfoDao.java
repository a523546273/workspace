package com.whw.layui.dao;

import com.whw.layui.po.WeiXinUserInfoPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeiXinUserInfoDao {

    int insert(WeiXinUserInfoPo weiXinUserInfoPo);

    WeiXinUserInfoPo selectByOpenid(String openid);

    void updateByPrimaryKey(WeiXinUserInfoPo weiXinUserInfoPo);

    WeiXinUserInfoPo getByInviteCode(@Param("inviteCode") String inviteCode);
}
