package cn.dlbdata.dangjian.admin.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: linfujun
 * @Description: 入口类
 * @Date: Created on 11:19 2018/3/25
 */
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = {"cn.dlbdata.dangjian.admin.*", "cn.dlbdata.dangjian.thirdparty.mp.sdk", "cn.dlbdata.dangjian.common"})
public class DangjianAdminApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DangjianAdminApplication.class, args);
    }
}
