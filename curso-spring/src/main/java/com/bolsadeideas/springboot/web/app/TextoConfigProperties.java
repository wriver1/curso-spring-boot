package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Esta clase le configura a Spring que existe otros archivos
 * properties a parte del aplication.properties, que para efecto
 * de este caso es textos.properties*/
@Configuration
@PropertySources({
	@PropertySource("classpath:textos.properties")
})
public class TextoConfigProperties {

}
