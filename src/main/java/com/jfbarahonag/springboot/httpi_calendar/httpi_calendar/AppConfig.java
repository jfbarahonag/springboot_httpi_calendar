package com.jfbarahonag.springboot.httpi_calendar.httpi_calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig implements WebMvcConfigurer {

  @Autowired
  @Qualifier(("calendarInterceptor"))
  HandlerInterceptor calendarInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(calendarInterceptor);
  }

}
