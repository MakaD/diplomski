package com.marinadamnjanovic.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("menadzer").password("menadzer").roles("MENADZER");
		auth.inMemoryAuthentication().withUser("zaposleni").password("zaposleni").roles("ZAPOSLENI");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  
	  http.authorizeRequests()
			  .antMatchers("/", "/home").permitAll()
			  .anyRequest().authenticated()
			  .and()
			  .formLogin()
			  .loginPage("/login")
			  .permitAll()
			  .and()
			  .logout()
			  .permitAll();
	}
}
