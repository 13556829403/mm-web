package com.admin.web.config;

import com.admin.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 拦截器配置
 * 不用权限可以访问 /api/pub/**
 * 需要权限访问    /api/pri/**
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    // 配置LoginInterceptor类
    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器  addPathPatterns: 配置拦截路径 excludePathPatterns:配置不拦截
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/pri/*/*/**")
                .excludePathPatterns("/pub/*/*/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
