package com.whw.layui.dao;

import com.whw.layui.po.AttendancePo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceDao {

    int deleteByPrimaryKey(Integer id);

    int insert(AttendancePo record);

    int insertSelective(AttendancePo record);

    AttendancePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttendancePo record);

    int updateByPrimaryKey(AttendancePo record);

    int selectCount(@Param("openid") String openid);

    int selectCountToday(@Param("openid") String openid);
}