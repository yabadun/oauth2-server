package com.local.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * oauth2授权服务器配置
 * 
 * @author lcp
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;

//	@Autowired
//	private DataSource dataSource;

	@Bean
	public TokenStore tokenStore() {
		// TODO 改为数据库或redis
		return new InMemoryTokenStore();

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
		endpoints.tokenStore(tokenStore());
		endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
				.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.jdbc(dataSource);
		clients.inMemory().withClient("AliGenie").authorizedGrantTypes("refresh_token", "authorization_code")
				.scopes("all").secret(passwordEncoder.encode("123456"))
				.redirectUris("http://localhost:9090/oauth/callback").accessTokenValiditySeconds(60 * 60 * 24)
				.refreshTokenValiditySeconds(60 * 60 * 24);
	}

}
