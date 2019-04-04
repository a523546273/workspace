package com.whw.layui.service.impl;

import com.whw.layui.contact.Contact;
import com.whw.layui.dao.WeiXinUserInfoDao;
import com.whw.layui.dao.WxuserValidateLogsDao;
import com.whw.layui.po.WeiXinUserInfoPo;
import com.whw.layui.po.WxuserValidateLogsPo;
import com.whw.layui.service.WeiXinUserInfoService;
import com.whw.layui.utils.CodeUtils;
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

    @Autowired
    private WxuserValidateLogsDao wxuserValidateLogsDao;

    @Override
    public void add(WeiXinUserInfoPo weiXinUserInfoPo) {
        WeiXinUserInfoPo po = weiXinUserInfoDao.selectByOpenid(weiXinUserInfoPo.getOpenid());
        if (po == null) {
            weiXinUserInfoPo.setRemark(CodeUtils.getCode(6));
            weiXinUserInfoDao.insert(weiXinUserInfoPo);
        }
    }

    @Override
    public void update(WeiXinUserInfoPo weiXinUserInfoPo) {
        weiXinUserInfoDao.updateByPrimaryKey(weiXinUserInfoPo);
    }

    @Override
    public WeiXinUserInfoPo selectByOpenid(String openid) {
        return weiXinUserInfoDao.selectByOpenid(openid);
    }

    @Override
    public void downSuccess(String openid) throws Exception {
        WeiXinUserInfoPo po = weiXinUserInfoDao.selectByOpenid(openid);
        if (po.getSubscribe() == 0) {
            throw new Exception("次数小于1");
        }
        po.setSubscribe(po.getSubscribe() - 1);
        weiXinUserInfoDao.updateByPrimaryKey(po);
    }

    @Override
    public void downShare(String openid) {
        WeiXinUserInfoPo po = weiXinUserInfoDao.selectByOpenid(openid);
        po.setSubscribe(po.getSubscribe() + Contact.shareNum);
        weiXinUserInfoDao.updateByPrimaryKey(po);
    }

    @Override
    public boolean validateCode(String openid, String inviteCode) throws Exception {

        WeiXinUserInfoPo po = weiXinUserInfoDao.getByInviteCode(inviteCode);

        /*if (po == null || po.getOpenid().equals(openid)) {
            throw new Exception("邀请码错误");
        }*/
        if (po == null) {
            throw new Exception("邀请码错误");
        }

        WxuserValidateLogsPo wxuserValidateLogsPo = wxuserValidateLogsDao.selectByOpenidAndCode(openid, inviteCode);
        if (wxuserValidateLogsPo != null) {
            throw new Exception("该验证码已经使用过");
        }
        po.setSubscribe(po.getSubscribe() + 5);

        WeiXinUserInfoPo ow = weiXinUserInfoDao.selectByOpenid(openid);
        ow.setSubscribe(ow.getSubscribe() + 10);

        weiXinUserInfoDao.updateByPrimaryKey(po);
        weiXinUserInfoDao.updateByPrimaryKey(ow);

        WxuserValidateLogsPo wxuserValidateLogsPo1=new WxuserValidateLogsPo();
        wxuserValidateLogsPo1.setOpenid(openid);
        wxuserValidateLogsPo1.setInviteCode(inviteCode);
        wxuserValidateLogsDao.insert(wxuserValidateLogsPo1);
        return true;
    }
}
