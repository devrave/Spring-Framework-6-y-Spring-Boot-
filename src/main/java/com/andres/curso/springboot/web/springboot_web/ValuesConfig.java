package com.andres.curso.springboot.web.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource(value="classpath:values.properties", encoding = "UTF-8") // Anotacion para poder reconocer mi archivo values.proprties,
  //nota: usando value y luego encoding configuramos el lenguaje UTF-8 Para el tema de acentos
	
})
public class ValuesConfig {
  

}
