package ar.com.galicia.pocapi.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Contexto de configuración de common.
 * 
 * @author mrsanchez
 */
@Configuration
@Import({ CommonSecurityConfig.class, CommonSwaggerConfig.class, CommonJpaConfig.class })
public class CommonConfig {

}
