package com.cloud.gateway.app.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(name = {"jwt.csrf.token.repository.disabled"}, havingValue = "true")
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private final Environment environment;
	
	@Autowired
	public WebSecurity(Environment environment) {
		this.environment = environment;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.cors(c -> {
		      CorsConfigurationSource source = request -> {
		        CorsConfiguration config = new CorsConfiguration();
		        config.setAllowedOrigins(
		            List.of("localhost"));
		        config.setAllowedMethods(
		            List.of("GET", "POST", "PUT", "DELETE"));
		        return config;
		      };
		      c.configurationSource(source);
		    });
		 
		    http.csrf().disable();
		 
		    http.authorizeRequests()
		         .anyRequest().permitAll();
	}
	
	
}
