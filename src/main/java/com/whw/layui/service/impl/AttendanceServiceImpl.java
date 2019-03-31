package com.whw.layui.service.impl;

import com.whw.layui.dao.AttendanceDao;
import com.whw.layui.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/31
 * Time:21:09
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;

    @Override
    public int selectCount(String openid) {
        return attendanceDao.selectCount(openid);
    }
}
