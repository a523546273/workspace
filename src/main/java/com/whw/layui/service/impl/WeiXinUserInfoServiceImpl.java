package com.whw.layui.service.impl;

import com.whw.layui.contact.Contact;
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

    @Override
    public void downSuccess(String openid) throws Exception {
        WeiXinUserInfoPo po = weiXinUserInfoDao.selectByOpenid(openid);
        if (po.getSubscribe()==0){
            throw new Exception("次数小于1");
        }
        po.setSubscribe(po.getSubscribe()-1);
        weiXinUserInfoDao.updateByPrimaryKey(po);
    }

    @Override
    public void downShare(String openid) {
        WeiXinUserInfoPo po = weiXinUserInfoDao.selectByOpenid(openid);
        po.setSubscribe(po.getSubscribe()+ Contact.shareNum);
        weiXinUserInfoDao.updateByPrimaryKey(po);
    }
}
