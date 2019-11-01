package com.local.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthProtectController {

	@GetMapping("/oauth/protect/{param}")
	public String test(@PathVariable("param") String param) {
		return param;
	}
}
