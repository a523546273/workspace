package com.whw.layui.controller;

import com.whw.layui.enums.ResultEnums;
import com.whw.layui.service.AttendanceService;
import com.whw.layui.utils.ResponseData;
import com.whw.layui.utils.ResponseDataUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/4/2
 * Time:22:48
 */
@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("attendance/insert")
    public ResponseData insert(String openid) {

        if (StringUtils.isBlank(openid)) {
            return ResponseDataUtil.buildError(ResultEnums.PARAM_ERROR);
        }
        try {
            int num = attendanceService.selectCountToday(openid);
            if (num > 0) {
                return ResponseDataUtil.buildError(ResultEnums.ATTENDANCE_ERROE);
            }
            attendanceService.insert(openid);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDataUtil.buildError(ResultEnums.SYSTEM_ERROR);
        }
        return ResponseDataUtil.buildSuccess();
    }
}
