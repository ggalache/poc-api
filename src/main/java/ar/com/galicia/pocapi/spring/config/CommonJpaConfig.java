package ar.com.galicia.pocapi.spring.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "dbAuditorProvider")
public class CommonJpaConfig {

    @Bean
    public AuditorAware<String> dbAuditorProvider() {
        return () -> Optional
    		.ofNullable(SecurityContextHolder.getContext())
			.map( SecurityContext::getAuthentication)
			.map( Authentication::getName )
        	.map( String::toUpperCase );
    }	
}
