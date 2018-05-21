/**
 * 
 */
package com.d2l2c.common.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dlazare
 *
 */
public class HttpUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

	private static final String USER_AGENT = "Mozilla/5.0";

	public static String send(String url, String username, String password) {
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
		provider.setCredentials(AuthScope.ANY, credentials);
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

		return send(client, url);
	}

	public static String send(String url) {
		HttpClient client = HttpClientBuilder.create().build();
		return send(client, url);
	}

	private static String send(HttpClient client, String url) {
		HttpGet request = new HttpGet(url);

		BufferedReader rd = null;
		InputStreamReader ResponseInputStreamReader = null;
		StringBuffer result = new StringBuffer();
		try {
			// add request header
			request.addHeader("User-Agent", USER_AGENT);
			HttpResponse response = client.execute(request);

			LOGGER.debug("Response Code : " + response.getStatusLine().getStatusCode());

			ResponseInputStreamReader = new InputStreamReader(response.getEntity().getContent());
			rd = new BufferedReader(ResponseInputStreamReader);

			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			if (rd != null) {
				try {
					rd.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage());
				}
			}
			if (ResponseInputStreamReader != null) {
				try {
					ResponseInputStreamReader.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage());
				}
			}
		}
		return result.toString();
	}

}
