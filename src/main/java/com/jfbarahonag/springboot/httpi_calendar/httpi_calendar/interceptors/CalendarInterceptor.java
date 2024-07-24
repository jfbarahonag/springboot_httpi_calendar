package com.jfbarahonag.springboot.httpi_calendar.httpi_calendar.interceptors;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CalendarInterceptor implements HandlerInterceptor {

  @Value("${customers.support.startTime}")
  private String startTime;
  
  @Value("${customers.support.finishTime}")
  private String finishTime;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    Calendar calendar = Calendar.getInstance();
    int currentHour = calendar.get(Calendar.HOUR_OF_DAY);

    boolean isValid = currentHour >= Integer.parseInt(finishTime) && currentHour < Integer.parseInt(finishTime);

    if (!isValid) {
      
      ObjectMapper mapper = new ObjectMapper();
      
      Map<String, Object> jsonObject = new HashMap<>();
      jsonObject.put("message", "The customer support works between " +  startTime + ":00 and " + finishTime + ":00 hrs");
      
      response.setStatus(HttpStatus.UNAUTHORIZED.value());
      response.getWriter().write(mapper.writeValueAsString(jsonObject));
    }

    return isValid;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {
    
  }

}
