package com.whw.layui.service.impl;

import com.whw.layui.dao.WxuserShareDao;
import com.whw.layui.po.WxuserSharePo;
import com.whw.layui.service.WxuserShareService;
import com.whw.layui.vo.WxuserShareVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/31
 * Time:23:35
 */
@Service
public class WxuserShareServiceImpl implements WxuserShareService {

    @Autowired
    private WxuserShareDao wxuserShareDao;

    @Override
    public int insert(WxuserShareVo vo) {

        WxuserSharePo po = new WxuserSharePo();
        BeanUtils.copyProperties(vo, po);
        po.setCreateDate(new Date());
        return wxuserShareDao.insert(po);
    }
}
