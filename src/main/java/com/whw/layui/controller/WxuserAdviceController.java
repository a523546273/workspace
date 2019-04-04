package com.whw.layui.controller;

import com.whw.layui.enums.ResultEnums;
import com.whw.layui.po.WxuserAdvicePo;
import com.whw.layui.service.WxuserAdviceService;
import com.whw.layui.utils.ResponseData;
import com.whw.layui.utils.ResponseDataUtil;
import com.whw.layui.vo.WxuserAdviceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/4/2
 * Time:19:26
 */
@RestController
public class WxuserAdviceController {

    @Autowired
    private WxuserAdviceService wxuserAdviceService;

    @PostMapping("/advice/insert")
    public ResponseData insert(WxuserAdviceVo wxuserAdviceVo) {

        try {

            List<WxuserAdvicePo> list = wxuserAdviceService.getListByOpenid(wxuserAdviceVo.getOpenid());

            if (list.size() > 3) {
                return ResponseDataUtil.buildError(ResultEnums.NUM_ERROR_3);
            }

            wxuserAdviceService.insert(wxuserAdviceVo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
        }
        return ResponseDataUtil.buildSuccess();
    }
}
