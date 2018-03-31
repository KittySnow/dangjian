package cn.dlbdata.dangjian.admin.web.interceptor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class InterceptorManage extends WebMvcConfigurerAdapter {
    public void addInterceptors(InterceptorRegistry registry) {
//        // 登陆拦截器
//        registry.addInterceptor(new LoginInterceptor())
//                .excludePathPatterns("/dex.html")
//                .excludePathPatterns("/puser/tologin", "/puser/login")
//                .excludePathPatterns("/pscorelevel/**")
//                .excludePathPatterns("/error")
//                .addPathPatterns("/**");
//
//        super.addInterceptors(registry);
    }
}