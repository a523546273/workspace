package com.whw.layui.service;

import com.whw.layui.po.WxuserAdvicePo;
import com.whw.layui.vo.WxuserAdviceVo;

import java.util.List;

public interface WxuserAdviceService {

    /**
     * 新增用户建议
     *
     * @param wxuserAdviceVo
     * @return
     */
    int insert(WxuserAdviceVo wxuserAdviceVo);

    /**
     * 根据用户openid获取当天建议
     *
     * @param openid 用户openid
     * @return
     */
    List<WxuserAdvicePo> getListByOpenid(String openid);

}
