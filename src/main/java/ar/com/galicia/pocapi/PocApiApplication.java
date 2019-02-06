package ar.com.galicia.pocapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import ar.com.galicia.pocapi.spring.config.CommonConfig;

@SpringBootApplication
@Import({ CommonConfig.class })
public class PocApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApiApplication.class, args);
	}
}