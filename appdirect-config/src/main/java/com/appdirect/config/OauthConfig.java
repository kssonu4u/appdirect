package com.appdirect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OauthConfig {

	@Value("${consumer.key}")
	private String consumerKey;

	@Value("${consumer.secret}")
	private String secret;

	@Bean
	public OauthSecret appDirectClient() {
		return new OauthSecret(consumerKey, secret);
	}

}
