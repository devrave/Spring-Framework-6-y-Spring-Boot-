package com.andres.curso.springboot.web.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.web.springboot_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(path = "/api/params")

public class RequestOParamController {

  //con foo solo estamos enviando un parametro

  @GetMapping("/foo")
  public ParamDto foo(@RequestParam String message) {

    ParamDto param = new ParamDto();
    param.setMessage(message);    
    return param;
  }

  //con la ruta bar estamos enviando multiples parametros, 
  //RUTA QUE PUSE EN EL NAVEGADOR -> http://localhost:8080/api/params/bar?text=hola&code=9

  @GetMapping("/bar")
  public ParamDto bar(@RequestParam String text, @RequestParam Integer code){

    ParamDto paramDto = new ParamDto();
    paramDto.setMessage(text);
    paramDto.setCode(code);
    return paramDto;

  }

  //otra manera de pasar parametros, pero de manera nativa con HttpServletRequest 'objeto nativo'

  @GetMapping("/request")
  public ParamDto request(HttpServletRequest request){
    //Este try que usamos es para que la exception no salga como error cuando da null
      Integer code = 0;
      try {
        code = Integer.parseInt(request.getParameter("code"));
      } catch (NumberFormatException e) {
        // TODO: handle exception
      }
    
    ParamDto param = new ParamDto();
    param.setCode(code);// si no pasamos el codigo nos va generar una excepcion, porque null no puede ser convertido a integer
    param.setMessage(request.getParameter("message"));
    return param;

  }

    
};
