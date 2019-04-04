package com.whw.layui.service;

import org.springframework.transaction.annotation.Transactional;

public interface AttendanceService {

    /**
     * 根据用户openid获取签到次数
     *
     * @param openid
     * @return
     */
    int selectCount(String openid);

    /**
     * 用户签到
     *
     * @param openid
     */
    @Transactional
    void insert(String openid) throws Exception;

    /**
     * 根据用户openid获取今日签到次数
     *
     * @param openid
     * @return
     */
    int selectCountToday(String openid);
}
