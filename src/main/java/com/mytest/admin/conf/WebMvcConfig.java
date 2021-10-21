package com.mytest.admin.conf;

import com.mytest.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * Filter、Interceptor几乎拥有相同的功能
     * Filter是Servlet定义的原生组件，脱离了Spring应用也能使用
     * Interceptor是Spring定义的接口。可以使用Spring的自动装配等功能。
     */



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
