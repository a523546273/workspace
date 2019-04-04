package com.whw.layui.dao;

import com.whw.layui.po.WxuserValidateLogsPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WxuserValidateLogsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(WxuserValidateLogsPo record);

    int insertSelective(WxuserValidateLogsPo record);

    WxuserValidateLogsPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxuserValidateLogsPo record);

    int updateByPrimaryKey(WxuserValidateLogsPo record);

    WxuserValidateLogsPo selectByOpenidAndCode(@Param("openid") String openid, @Param("inviteCode") String inviteCode);
}