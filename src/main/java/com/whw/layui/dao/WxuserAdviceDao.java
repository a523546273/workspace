package com.whw.layui.dao;

import com.whw.layui.po.WxuserAdvicePo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WxuserAdviceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(WxuserAdvicePo record);

    int insertSelective(WxuserAdvicePo record);

    WxuserAdvicePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxuserAdvicePo record);

    int updateByPrimaryKey(WxuserAdvicePo record);

    List<WxuserAdvicePo> getListByOpenid(@Param("openid") String openid);
}