package com.therich.apps.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * ViewResolve, Converter, Formatter 관리
 */

@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjar/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }
}
