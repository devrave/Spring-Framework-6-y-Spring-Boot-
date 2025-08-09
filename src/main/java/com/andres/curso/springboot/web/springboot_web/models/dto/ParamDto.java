package com.andres.curso.springboot.web.springboot_web.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) //Esta anotación me sirve para que cuando se realicé la serialización no tome valores nulos
public class ParamDto {

  private String message;
  private Integer code;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  
  

}
