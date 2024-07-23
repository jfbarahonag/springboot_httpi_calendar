package com.jfbarahonag.springboot.httpi_calendar.httpi_calendar.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers/support")
public class AppController {

  @GetMapping
  public ResponseEntity<?> index() {
    
    Map<String, Object> data = new HashMap<>();
    data.put("title", "Wellcome to the customer support");
    data.put("timestamp", new Date().getTime());

    return ResponseEntity.ok(data);
  
  }
}
