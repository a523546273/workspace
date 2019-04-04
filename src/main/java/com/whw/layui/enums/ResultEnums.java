package com.whw.layui.enums;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/30
 * Time:22:03
 */
public enum ResultEnums {

    SUCCESS("0", "请求成功"),
    ERROR("1", "请求失败"),
    NULL_USER("10002","查询用户信息失败"),
    SYSTEM_ERROR("10001", "请求服务器异常"),
    BUSSINESS_ERROR("20001", "业务逻辑错误"),
    VERIFY_CODE_ERROR("20002", "业务参数错误"),
    PARAM_ERROR("20002", "业务参数错误"),
    NUM_ERROR_3("20003", "每天限三条建议"),
    ATTENDANCE_ERROE("20004", "今日已经签到!");


    private String code;
    private String msg;

    ResultEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
