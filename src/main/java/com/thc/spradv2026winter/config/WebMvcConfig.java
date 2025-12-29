package com.thc.spradv2026winter.config;

import com.thc.spradv2026winter.Interceptor.DefaultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    // 인터셉터 설정을 위함
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DefaultInterceptor())
                .addPathPatterns("/api/**") // 인터셉터가 실행되야 하는 URL 패턴
                .excludePathPatterns("/resources/**", "/api/auth", "/api/user/signup", "/api/user/login"); // 인터셉터가 실행되지 않아야 하는 URL 패턴
    }
}
