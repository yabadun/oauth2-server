package com.local.oauth2;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainTest {

	public static void main(String[] args) {

		System.out.println(new BCryptPasswordEncoder().encode("933615"));
	}

}
