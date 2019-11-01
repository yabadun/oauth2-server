package com.local.oauth.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring-security 配置
 * 
 * @author lcp
 *
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return encodedPassword.equals(rawPassword.toString());
			}

		};
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return username -> new User(username, "111111", new ArrayList<>());

	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic().disable();
		http.requestMatchers().antMatchers("/oauth/**", "/login/**").and().authorizeRequests()
				.antMatchers("/oauth/**", "/login/**").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/index.html").loginProcessingUrl("/login");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}
}
