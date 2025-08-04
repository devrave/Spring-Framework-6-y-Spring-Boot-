package com.andres.curso.springboot.web.springboot_web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.andres.curso.springboot.web.springboot_web.models.User;



//Esto es un ejemplo de un controlador a partir del mismo servidor 
@Controller
public class UserController {
 
  @GetMapping("/details")
  public String details(Model model){  // Tambien en vez de Mode podemos utilizar Map<Srtring, Object> y abajo con .put

    User user = new User("Andres","Cano");    
    user.setEmail("a.canorave@gmail.com");
    model.addAttribute("title", "Hola mundo Spring boot");
    model.addAttribute("user", user);
    
    return "details";
  }

  @GetMapping("/list")
  public String list(ModelMap model) {
      List<User> users = new ArrayList<>();

      model.addAttribute("users",users);
      model.addAttribute("title", "Listado de usuarios");
      return "list";
  }
  

}
