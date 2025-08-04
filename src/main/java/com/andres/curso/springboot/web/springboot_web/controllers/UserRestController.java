package com.andres.curso.springboot.web.springboot_web.controllers;


//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.web.springboot_web.models.User;
import com.andres.curso.springboot.web.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("api")
public class UserRestController {
 

  //Metodo usando un DTO
  @GetMapping("/details")
  public UserDto details(){ 
    UserDto userDto = new UserDto();
    User user = new User("Juan", "Orozco");
    userDto.setUser(user);  
    userDto.setTitile("Hola mundo Spring boot"); 
    
    
    return userDto;
  }

  @GetMapping(path = "/list")
  public List<User> list(){
    User user = new User("Andrés","Cano");
    User user2 = new User("Pepe","Mesa");
    User user3 = new User("Alex","Castro");

   //Aqui vamos a usar un helper
   List<User> users = Arrays.asList(user,user2,user3);


    //Arraylist
    // List<User> users = new ArrayList<>();
    // users.add(user);
    // users.add(user2);
    // users.add(user3);

    return users;


  }


  //Metodo de api
  @GetMapping("/details-map")
  public Map<String, Object> detailsMap(){ 
    User user = new User("Juan", "Orozco");
    Map<String, Object> body = new HashMap<>();
    body.put("title", "Hola mundo Spring boot");
    body.put("user", user);
    
    return body;
  }
}


