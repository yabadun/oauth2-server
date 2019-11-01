package com.local.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthProtectController {

	@Autowired
	TokenStore tokenStore;

	@GetMapping("/oauth/protect/{param}")
	public String test(@PathVariable("param") String param, @RequestParam("access_token") String token) {
		OAuth2Authentication info = tokenStore.readAuthentication(token);
		return info.getName()+"-"+param;
	}
}
