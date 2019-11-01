package com.local.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
/**
 * 资源服务器配置
 * @author lcp
 *
 */
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/oauth/protect/**").and().authorizeRequests()
				.antMatchers("/oauth/protect/**").authenticated();
	}

}
