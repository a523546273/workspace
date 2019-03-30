package com.whw.layui.service.impl;

import com.whw.layui.dao.WeiXinUserInfoDao;
import com.whw.layui.po.WeiXinUserInfoPo;
import com.whw.layui.service.WeiXinUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/30
 * Time:21:41
 */
@Service
public class WeiXinUserInfoServiceImpl implements WeiXinUserInfoService {

    @Autowired
    private WeiXinUserInfoDao weiXinUserInfoDao;

    @Override
    public void add(WeiXinUserInfoPo weiXinUserInfoPo) {
        WeiXinUserInfoPo po = weiXinUserInfoDao.selectByOpenid(weiXinUserInfoPo.getOpenid());
        if (po == null) {
            weiXinUserInfoDao.insert(weiXinUserInfoPo);
        }
    }

    @Override
    public WeiXinUserInfoPo selectByOpenid(String openid) {
        return weiXinUserInfoDao.selectByOpenid(openid);
    }
}
