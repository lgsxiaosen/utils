package com.github.lgsxiaosen.utils.utils.config;

import com.github.lgsxiaosen.utils.utils.interceptor.GlobalInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author xiaosen
 */
@Configuration
public class SpringMvcConfigure extends WebMvcConfigurationSupport {

    public SpringMvcConfigure() {
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/").addResourceLocations("/**");
    }

    /**
     * 配置servlet处理
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.myInterceptor()).addPathPatterns("/**").excludePathPatterns("/actuator/**");
        super.addInterceptors(registry);
    }

    @Bean
    public GlobalInterceptor myInterceptor() {
        return new GlobalInterceptor();
    }

}
