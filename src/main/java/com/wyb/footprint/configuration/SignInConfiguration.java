package com.wyb.footprint.configuration;

import com.wyb.footprint.interceptor.SignInHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author William Wang
 */
@Configuration
public class SignInConfiguration implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(new SignInHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/signIn","/toSignIn","/signUp","/toSignUp","/userName/**");
    }
}
