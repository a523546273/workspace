package com.whw.layui.service.impl;

import com.whw.layui.dao.AttendanceDao;
import com.whw.layui.dao.WeiXinUserInfoDao;
import com.whw.layui.po.AttendancePo;
import com.whw.layui.po.WeiXinUserInfoPo;
import com.whw.layui.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Autowired
    private WeiXinUserInfoDao weiXinUserInfoDao;

    @Override
    public int selectCount(String openid) {
        return attendanceDao.selectCount(openid);
    }

    @Override
    public int selectCountToday(String openid) {
        return attendanceDao.selectCountToday(openid);
    }

    @Override
    public void insert(String openid) throws Exception {
        AttendancePo po = new AttendancePo();
        po.setOpenid(openid);
        po.setCreateDate(new Date());
        attendanceDao.insert(po);

        WeiXinUserInfoPo weiXinUserInfoPo = weiXinUserInfoDao.selectByOpenid(openid);
        weiXinUserInfoPo.setSubscribe(weiXinUserInfoPo.getSubscribe() + 2);
        weiXinUserInfoDao.updateByPrimaryKey(weiXinUserInfoPo);
    }
}
