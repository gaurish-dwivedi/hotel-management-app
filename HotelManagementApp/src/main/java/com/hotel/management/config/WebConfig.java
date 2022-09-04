//package com.hotel.management.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@SuppressWarnings("deprecation")
//public class WebConfig extends WebSecurityConfigurerAdapter {
//
//	@Bean
//	public UserDetailsService getUserDetailsService() {
//		return new UserDetailsServiceImpl();
//	}
//
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
//
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//		return daoAuthenticationProvider;
//
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider());
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//////		http.authorizeHttpRequests().antMatchers("/hotel/**").hasAnyRole("MANAGER").antMatchers("/users/**")
//////				.hasAnyRole("USER").antMatchers("/rooms/**").hasAnyRole("ADMIN").antMatchers("/**").permitAll().and()
//////				.httpBasic().and().csrf().and().cors().disable();
////
////		http.authorizeRequests().antMatchers(HttpMethod.GET).hasRole("MANAGER");
////
////		http.cors().disable();
////		http.csrf().disable();
//
//	}
//
//}
