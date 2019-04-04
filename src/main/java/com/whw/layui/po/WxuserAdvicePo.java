package com.whw.layui.po;

import java.io.Serializable;
import java.util.Date;

/**
 * wxuser_advice
 * @author 
 */
public class WxuserAdvicePo implements Serializable {
    private Integer id;

    /**
     * 用户唯一标示
     */
    private String openid;

    /**
     * 建议
     */
    private String advice;

    /**
     * 微信号
     */
    private String wechatNumber;

    /**
     * 无效视频链接
     */
    private String disableUrl;

    /**
     * 照片
     */
    private String photo;

    /**
     * 创建日期
     */
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber;
    }

    public String getDisableUrl() {
        return disableUrl;
    }

    public void setDisableUrl(String disableUrl) {
        this.disableUrl = disableUrl;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}