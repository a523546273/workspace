package com.whw.layui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LayuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LayuiApplication.class, args);
    }

}
