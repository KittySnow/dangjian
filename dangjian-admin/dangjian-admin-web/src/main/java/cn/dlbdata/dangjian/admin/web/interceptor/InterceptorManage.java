package cn.dlbdata.dangjian.admin.web.interceptor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class InterceptorManage extends WebMvcConfigurerAdapter {
    public void addInterceptors(InterceptorRegistry registry) {
        // 登陆拦截器
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/puser/tologin", "/puser/login")
                .excludePathPatterns("/dangjian/puser/tologin", "/dangjian/puser/login")
                .excludePathPatterns("/mp/**", "/dangjian/mp/**")
                .excludePathPatterns("/wechat/**", "/dangjian/wechat/**")
                .excludePathPatterns("/error", "/dangjian/error")
                .addPathPatterns("/**")
        ;

        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态资源访问映射
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
