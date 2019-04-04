package com.whw.layui.controller;

import com.whw.layui.enums.ResultEnums;
import com.whw.layui.service.AttendanceService;
import com.whw.layui.service.WeiXinUserInfoService;
import com.whw.layui.utils.ParseUrlUtils;
import com.whw.layui.utils.ResponseData;
import com.whw.layui.utils.ResponseDataUtil;
import com.whw.layui.vo.rsp.TaskComplete;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DownLoadController {

    @Autowired
    private WeiXinUserInfoService weiXinUserInfoService;

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping(value = "/down/download")
    public ResponseData<String> dowload(String url) {

        if (StringUtils.isBlank(url)) {
            return ResponseDataUtil.buildError(ResultEnums.PARAM_ERROR);
        }

        url = url.trim();

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

    @PostMapping("/down/doShare")
    public ResponseData doShare(String openid) {
        if (StringUtils.isBlank(openid)) {
            return ResponseDataUtil.buildError(ResultEnums.PARAM_ERROR);
        }
        try {
            weiXinUserInfoService.downShare(openid);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
        }
        return ResponseDataUtil.buildSuccess();
    }

    @PostMapping("/down/task")
    public ResponseData<TaskComplete> task(String openid) {

        if (StringUtils.isBlank(openid)) {
            return ResponseDataUtil.buildError(ResultEnums.PARAM_ERROR);
        }

        TaskComplete taskComplete = new TaskComplete();
        try {
            int num = attendanceService.selectCountToday(openid);
            if (num > 0) {
                taskComplete.setTask3(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
        }

        return ResponseDataUtil.buildSuccess(taskComplete);
    }


    @PostMapping("/down/validate")
    public ResponseData validate(String openid, String inviteCode) {

        if (StringUtils.isBlank(openid) || StringUtils.isBlank(inviteCode)) {
            return ResponseDataUtil.buildError(ResultEnums.PARAM_ERROR);
        }

        try {
            weiXinUserInfoService.validateCode(openid, inviteCode);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDataUtil.buildError(e.getMessage());
        }

        return ResponseDataUtil.buildSuccess();
    }
}
