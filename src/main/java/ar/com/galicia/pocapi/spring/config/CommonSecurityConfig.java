package ar.com.galicia.pocapi.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CommonSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = {
			// -- swagger ui
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui.html",
			"/v1/login",
			"/actuator/**",
			"/webjars/**",
			"/services/**",
			"/h2-console/**"
	};

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;


	//@Autowired
	//private MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler;

	private SimpleUrlAuthenticationFailureHandler myFailureHandler = new SimpleUrlAuthenticationFailureHandler();

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors().and()
				//Deshabilitar el control de CSRF
				.csrf().disable()
			.authorizeRequests()
				.antMatchers(AUTH_WHITELIST).permitAll() // authenticated()
			.and()
				.formLogin()
					.loginPage("/v1/login")
				//.successHandler(mySuccessHandler)
				//.failureHandler(myFailureHandler)
				.and()
					.httpBasic()
				.and()
					// By default, a logout request invalidates the session, clears any authentication caches,
					// clears the SecurityContextHolder and redirects to login page.
					.logout().logoutUrl("/v1/logout");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
	}

	@Autowired
	private DataSource dataSource;


}
