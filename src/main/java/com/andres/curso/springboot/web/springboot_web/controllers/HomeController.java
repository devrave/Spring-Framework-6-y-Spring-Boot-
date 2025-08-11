package com.andres.curso.springboot.web.springboot_web.controllers;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  

  @GetMapping(path={"","/","/home"})
  public String homeRedirect(){
    return "redirect:/details";// con redirect para llevarnos a la ruta de otros metodos
  }

  
  @GetMapping(path={"/homeforward"})
  public String homeForward(){
    return "forward:/details";// con redirect para llevarnos a la ruta de otros metodos
  }


}
