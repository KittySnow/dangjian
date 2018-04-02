package cn.dlbdata.dangjian.thirdparty.mp.sdk.service.impl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 22:41 2018/3/24
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.dlbdata.dangjian.common", "cn.dlbdata.dangjian.thirdparty.mp.sdk.*"})
public class SdkApplication {
}
