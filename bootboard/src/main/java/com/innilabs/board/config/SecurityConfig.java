package com.innilabs.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean 
	  public PasswordEncoder passwordEncoder() { // 4
	    return new BCryptPasswordEncoder();
	  }

	  @Override
	  public void configure(WebSecurity web) { // 5
	    web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	  }

	  @Override
	  protected void configure(HttpSecurity http) throws Exception { // 6
		http
			.csrf().disable()
			.cors().disable()
	          .authorizeRequests() // 7
				  .antMatchers("/**").permitAll()
				  .anyRequest().permitAll()
	    ;
	  }

	 
}
