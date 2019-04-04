package com.whw.layui.service;

import com.whw.layui.vo.WxuserShareVo;

public interface WxuserShareService {

    /**
     * 新增微信分享记录
     * @param record
     * @return
     */
    int insert(WxuserShareVo record);
}
