
package com.fourm.fourm.config;

import com.fourm.fourm.filter.NewsFilter;
import com.fourm.fourm.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanRegisterConfig {
    @Bean
    public FilterRegistrationBean createFilterBean() {
        //过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TokenFilter());
        registration.addUrlPatterns("/forumArticle/*"); //需要过滤的接口
        //registration.addInitParameter();设置不需要过滤的
        registration.setOrder(1);//filter设置优先级
        return registration;
    }
    @Bean
    public FilterRegistrationBean newsFilterBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new NewsFilter());
        registration.addUrlPatterns("/News/*");
        registration.setOrder(2);
        return registration;
    }

}

