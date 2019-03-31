package com.whw.layui.service;

public interface AttendanceService {

    /**
     * 根据用户openid获取签到次数
     * @param openid
     * @return
     */
    int selectCount(String openid);
}
