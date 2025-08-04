package com.andres.curso.springboot.web.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.web.springboot_web.models.dto.ParamDto;


@RestController
@RequestMapping(path = "/api/params")

public class RequestOParamController {


  @GetMapping("/foo")
  public ParamDto foo(@RequestParam String message) {

    ParamDto param = new ParamDto();
    param.setMessage(message);
    
    return param;
  }
    
};
