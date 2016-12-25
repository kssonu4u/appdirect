package com.appdirect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author saurav Picks up the value of consumer key and consumer secret from
 *         application properties and create a bean object of it
 *
 */
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
