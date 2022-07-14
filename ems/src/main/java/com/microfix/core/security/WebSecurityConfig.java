package com.microfix.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//http.authorizeHttpRequests((authz) -> authz.antMatchers("/*").permitAll()
		http.authorizeHttpRequests((authz) -> authz.anyRequest( ).permitAll() 
				//.anyRequest().authenticated() 
		// .httpBasic(withDefaults())
		 
		)
		;
		
		// Disable the CORS to allow access from cross site (i.e. POST man)
		http.cors().and().csrf().disable();
		
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {

		//UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
		//		.build();

		UserDetails user2 = User.withUsername("user1").password(passwordEncoder().encode("123")).roles("USER")
				.build();

		// .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
		// .and()
		// .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");

		return new InMemoryUserDetailsManager(user2);
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests() .antMatchers("/", "/home").permitAll()
	 * .anyRequest().authenticated() .and() .formLogin() .loginPage("/login")
	 * .permitAll() .and() .logout() .permitAll(); }
	 * 
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() { UserDetails user =
	 * User.withDefaultPasswordEncoder() .username("user") .password("password")
	 * .roles("USER") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 * 
	 */
}
