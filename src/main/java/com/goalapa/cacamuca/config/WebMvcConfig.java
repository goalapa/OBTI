package com.goalapa.cacamuca.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/review/**")
                .addResourceLocations("file:///C:/app-file/uploadFiles/");
        registry.addResourceHandler("/request/**")
                .addResourceLocations("file:///C:/app-file/uploadFiles/");
    }

}
