package com.andres.curso.springboot.web.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.andres.curso.springboot.web.springboot_web.models.User;
import com.andres.curso.springboot.web.springboot_web.models.dto.ParamDto;

@RestController // Para apirest
@RequestMapping(path = "api/var") // para ruta inicial, ruta base
public class PathVariableController {

  // vamos a crear variables para poder incluir las configuraciones de nuestro
  // values.properties
  @Value("${config.code}")
  private Integer code;

  @Value("${config.username}")
  private String username;

  @Value("${config.message}")
  private String message;

  @Value("${config.listOfValues}")
  private List<String> listOfValues;
  // private String[] listOfValues = tambien se puede utilizar el array pero es
  // mas manejable la list

  // # indica a Spring que debe evaluar la expresión como una expresión SpEL
  // (Spring Expression Language).
  // Esto es necesario cuando quieres inyectar un valor complejo, como un Map,
  // desde el archivo de propiedades.
  @Value("#{${config.valuesMap}}")
  private Map<String, Object> valuesMap;

  @Value("#{${config.valuesMap}.product}")
  private String product;

  @Value("#{${config.valuesMap}.price}")
  private String price;


  @Autowired
  private Environment environment; // Por medio de inyeccion de dependencias, hace mas directo el extraer los valores del properties.






  // Con la anotacion PathVariale se envia informacion a traves de la ruta y no de
  // la url
  // para APIREST, se aconseja por ruta
  @GetMapping(path = "baz/{hola}")
  public ParamDto baz(@PathVariable(name = "hola") String message) {// si ponemos la propiedad de name debe ser igual a
                                                                    // la de la ruta

    ParamDto param = new ParamDto();
    param.setMessage(message);

    return param;
  }

  // Con un Map llamando varias varibles
  @GetMapping(path = "/mix/{product}/{id}")
  public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
    Map<String, Object> json = new HashMap<>();
    json.put("producto", product);
    json.put("id", id);

    return json;

  }

  // Ejemplo: con el DTO llamando varias variables
  @GetMapping(path = "pro/{item}/{id}")
  public ParamDto prueba(@PathVariable String item, @PathVariable Integer id) {

    ParamDto newpar = new ParamDto();
    newpar.setMessage(item);
    newpar.setCode(id);
    return newpar;
  }

  // Uso de postman con los siguientes metodos

  @PostMapping("create")
  public User create(@RequestBody User user) {
    // hacer algo con el usuario save en la bbdd
    return user;
  }

  // GetMapping de los value.properties

  @GetMapping(path = "/values")
  public Map<String, Object> values() {
    Map<String, Object> json = new HashMap<>();
    json.put("username", username);
    json.put("code", code);
    json.put("message", message);
    json.put("message2", environment.getProperty("config.message"));
    json.put("code2", Integer.valueOf(environment.getProperty("config.code"))); //get property returna string, otra manera es usar config.code, Long.class o Integer.class
    json.put("listOfValues", listOfValues);
    json.put("valuesMap", valuesMap);
    json.put("product", product);
    json.put("price",price);

    return json;

  }

}
