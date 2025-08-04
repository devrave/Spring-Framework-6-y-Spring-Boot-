package com.andres.curso.springboot.web.springboot_web.controllers;

import java.rmi.server.LogStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
      List<User> users =  Arrays.asList(
      // new User("Andres", "Cano", "a.canorave@gmail.com"),
      // new User("Maria", "Lopez", "m.lopez@gmail.com"),
      // new User("Juan", "Perez")
      );

      model.addAttribute("users",users);
      model.addAttribute("title", "Listado de usuarios");
      return "list";
  }


  @ModelAttribute("users")
  public List<User> usersModel(){
    List<User> users = Arrays.asList(
      new User("Andres", "Cano", "a.canorave@gmail.com"),
      new User("Maria", "Lopez", "m.lopez@gmail.com"),
      new User("Juan", "Perez"));
      return users;

  }

  

}
