package com.whw.layui.controller;

import com.whw.layui.enums.ResultEnums;
import com.whw.layui.service.WeiXinUserInfoService;
import com.whw.layui.utils.ParseUrlUtils;
import com.whw.layui.utils.ResponseData;
import com.whw.layui.utils.ResponseDataUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DownLoadController {

    @Autowired
    private WeiXinUserInfoService weiXinUserInfoService;

    @PostMapping(value = "/down/download")
    public ResponseData<String> dowload(String url) {

        if (StringUtils.isBlank(url)) {
            return ResponseDataUtil.buildError(ResultEnums.PARAM_ERROR);
        }

        String url1 = ParseUrlUtils.downLoad(url);

        if (StringUtils.isBlank(url1)) {
            return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
        } else {
            return ResponseDataUtil.buildSuccess(url1);
        }

    }


    @PostMapping("/down/downSuccess")
    public ResponseData downSuccess(String openid) {
        if (StringUtils.isBlank(openid)) {
            return ResponseDataUtil.buildError(ResultEnums.PARAM_ERROR);
        }
        try {
            weiXinUserInfoService.downSuccess(openid);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
        }
        return ResponseDataUtil.buildSuccess();
    }


}
