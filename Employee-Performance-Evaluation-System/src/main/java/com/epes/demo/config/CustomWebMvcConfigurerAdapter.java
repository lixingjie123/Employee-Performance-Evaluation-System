package com.epes.demo.config;

/**
 * Description:
 * Date: 2018/2/23
 * Time: 16:36
 *
 * @Author lixingjie
 * @Modifice
 */

import com.epes.demo.tool.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *file: CustomWebMvcConfigurerAdapter.java
 * Created by jiaobuchong on 12/23/15.
 */

@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对来自所有的请求进行拦截
        registry.addInterceptor(new CommonInterceptor()).addPathPatterns("*");
    }
}
