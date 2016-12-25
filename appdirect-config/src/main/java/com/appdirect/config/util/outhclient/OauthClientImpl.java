package com.appdirect.config.util.outhclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appdirect.config.OauthSecret;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.signature.QueryStringSigningStrategy;

/**
 * @author saurav
 * This class is used for getting signed fetch request from appdirect
 *
 */
@Component
public class OauthClientImpl implements OauthClient {

	private static final Logger logger = LoggerFactory.getLogger(OauthClientImpl.class);

	@Autowired
	private OauthSecret oauthSecret;

	@Override
	public String getEventInfo(String eventUrl) throws IOException, OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException {
		// TODO Auto-generated method stub
		logger.info("Getting event details from appDirect server for eventURL: " + eventUrl);
		OAuthConsumer consumer = new DefaultOAuthConsumer(oauthSecret.getConsumerKey(),
				oauthSecret.getConsumersecret());
		consumer.setSigningStrategy(new QueryStringSigningStrategy());

		URL url = new URL(consumer.sign(eventUrl));

		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("Accept", "application/json");
		logger.debug("Sending request for URL:" + eventUrl);
		connection.connect();
		logger.debug("Response: " + connection.getResponseCode() + " " + connection.getResponseMessage()
				+ "received for event URL: " + eventUrl);

		// process stream to get JSON string
		BufferedReader br = null;
		if (199 < connection.getResponseCode() && connection.getResponseCode() < 300) {
			br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		} else {
			br = new BufferedReader(new InputStreamReader((connection.getErrorStream())));
		}

		StringBuilder sb = new StringBuilder();

		String line;
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			logger.debug("Error occured while processing response for URL: " + eventUrl);
			throw new IOException("IO Exception while processing event for URL: " + eventUrl);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.debug("Error occured while processing bufferreader for  URL: " + eventUrl);
					throw new IOException("IO Exception while processing bufferreader for URL: " + eventUrl);
				}
			}
		}

		return sb.toString();
	}

}
