package com.andres.curso.springboot.web.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:values.properties") // Anotacion para poder reconocer mi archivo values.proprties,

	
})
public class ValuesConfig {
  

}
