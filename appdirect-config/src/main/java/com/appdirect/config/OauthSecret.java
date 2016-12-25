package com.appdirect.config;

/**
 * @author saurav Produces Signed-Oauth Consumer-Secret And Consumer-key.
 *
 */
public class OauthSecret {

	private String consumerKey;

	private String consumersecret;

	public OauthSecret(String consumerKey, String consumersecret) {
		this.consumerKey = consumerKey;
		this.consumersecret = consumersecret;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumersecret() {
		return consumersecret;
	}

	public void setConsumersecret(String consumersecret) {
		this.consumersecret = consumersecret;
	}

}
