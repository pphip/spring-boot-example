package com.ppship.spring_boot_helloworld;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import junit.framework.Assert;

import org.junit.Test;

public class SimpleTest {
	@Test
	public void test() throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		// sb.append("https://play.google.com/store/apps/details?id=com.playdonut.android&referrer=");
		String source = "playdonut";
		String medium = "recommender";
		String term = "term";
		String content = "{\"recommenderNickname\":\"abc\"}";
		String campaign = "name";
		sb.append("utm_source").append("=")
				.append(URLEncoder.encode(source, "UTF-8")).append("&");
		sb.append("utm_medium").append("=")
				.append(URLEncoder.encode(medium, "UTF-8")).append("&");
		sb.append("utm_term").append("=")
				.append(URLEncoder.encode(term, "UTF-8")).append("&");
		sb.append("utm_content").append("=")
				.append(URLEncoder.encode(content, "UTF-8")).append("&");
		sb.append("utm_campaign").append("=")
				.append(URLEncoder.encode(campaign, "UTF-8"));

		Assert.assertEquals(
				"https://play.google.com/store/apps/details?id=com.playdonut.android&referrer=utm_source%3Dplaydonut%26utm_medium%3Drecommender%26utm_term%3Dterm%26utm_content%3D%257B%2522recommenderNickname%2522%253A%2522abc%2522%257D%26utm_campaign%3Dname", //
				"https://play.google.com/store/apps/details?id=com.playdonut.android&referrer="
						+ URLEncoder.encode(sb.toString(), "UTF-8"));
	}
}
