package com.andres.curso.springboot.web.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.web.springboot_web.models.dto.ParamDto;

@RestController //Para apirest
@RequestMapping(path = "api/var") //para ruta inicial, ruta base
public class PathVariableController {


  // Con la anotacion PathVariale se envia informacion a traves de la ruta y no de la url
  // para APIREST, se aconseja por ruta
  @GetMapping(path = "baz/{hola}")
  public ParamDto baz(@PathVariable (name = "hola") String message){//si ponemos la propiedad de name debe ser igual a la de la ruta

    ParamDto param = new ParamDto();
    param.setMessage(message);

    return param;
  }


  // Con un Map llamando varias varibles
  @GetMapping(path = "/mix/{product}/{id}")
  public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){
    Map<String, Object> json = new HashMap<>();
    json.put("producto", product);
    json.put("id", id);


    return json;

  }


  // Ejemplo: con el DTO llamando varias variables
  @GetMapping(path = "pro/{item}/{id}")
  public ParamDto prueba(@PathVariable String item, @PathVariable Integer id){

    ParamDto newpar = new ParamDto();
    newpar.setMessage(item);
    newpar.setCode(id);
    return newpar;
  }

}
