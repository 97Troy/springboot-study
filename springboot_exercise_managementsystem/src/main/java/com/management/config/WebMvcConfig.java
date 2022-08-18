package com.management.config;

import com.management.controller.interceptor.AuthorityInterceptor;
import com.management.controller.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private AuthorityInterceptor authorityInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(authorityInterceptor)
               .addPathPatterns("/pages/**")
               .excludePathPatterns("/pages/login.html","/pages/register.html");



        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/pages/**")
                .excludePathPatterns("/pages/login.html","/pages/register.html");
    }



}
