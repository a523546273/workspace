package com.whw.layui.dao;

import com.whw.layui.po.WxuserSharePo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WxuserShareDao {
    int deleteByPrimaryKey(Integer id);

    int insert(WxuserSharePo record);

    int insertSelective(WxuserSharePo record);

    WxuserSharePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxuserSharePo record);

    int updateByPrimaryKey(WxuserSharePo record);

    WxuserSharePo selectByOpenid(@Param("openid") String openid);
}