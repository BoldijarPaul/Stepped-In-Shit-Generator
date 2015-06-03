package com.boldijarpaul.eww.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.boldijarpaul.eww.service.ImageManagement;

public class HttpHelper {

	/* this method will read the url text */
	public static String urlToString(String url) {
		try {
			URL yahoo = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					yahoo.openStream()));

			String result = "";
			String inputLine;

			while ((inputLine = in.readLine()) != null)
				result += inputLine;

			in.close();
			return result;
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	/* gets the redirect url of a url */
	public static String getRedirectedURL(String url) {
		try {
			HttpURLConnection con = (HttpURLConnection) new URL(url)
					.openConnection();
			con.setInstanceFollowRedirects(false);
			con.connect();
			con.getInputStream();
			String redirectUrl = con.getHeaderField("Location");
			return redirectUrl;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		// String test1 =
		// getRedirectedURL("https://graph.facebook.com/67563683055/picture?type=large");
		// String test2 = urlToString("https://graph.facebook.com/cnn");
		// System.out.println(test2);
		//
		// System.out.println(test1);
		System.out.println(ImageManagement.createImage("cnn"));
	}
}
