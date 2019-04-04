package com.whw.layui.service.impl;

import com.whw.layui.dao.WxuserAdviceDao;
import com.whw.layui.po.WxuserAdvicePo;
import com.whw.layui.service.WxuserAdviceService;
import com.whw.layui.vo.WxuserAdviceVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/4/2
 * Time:19:19
 */
@Service
public class WxuserAdviceServiceImpl implements WxuserAdviceService {

    @Autowired
    private WxuserAdviceDao wxuserAdviceDao;


    @Override
    public int insert(WxuserAdviceVo wxuserAdviceVo) {

        WxuserAdvicePo po = new WxuserAdvicePo();
        BeanUtils.copyProperties(wxuserAdviceVo, po);
        po.setCreateDate(new Date());
        return wxuserAdviceDao.insert(po);
    }

    @Override
    public List<WxuserAdvicePo> getListByOpenid(String openid) {
        return wxuserAdviceDao.getListByOpenid(openid);
    }
}
