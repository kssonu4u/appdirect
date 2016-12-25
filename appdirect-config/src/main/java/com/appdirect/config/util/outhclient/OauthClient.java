package com.appdirect.config.util.outhclient;

import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/**
 * @author saurav
 *
 */
public interface OauthClient {
	public String getEventInfo(String eventUrl) throws IOException, OAuthMessageSignerException,
	OAuthExpectationFailedException, OAuthCommunicationException;
}
