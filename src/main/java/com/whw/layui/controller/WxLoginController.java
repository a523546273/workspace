package com.whw.layui.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/30
 * Time:11:31
 */
@RestController
public class WxLoginController {

    @PostMapping("/wxLogin")
    public Map wxLogin(String code){

        System.out.println("code"+code);
        return new HashMap();
    }

}
