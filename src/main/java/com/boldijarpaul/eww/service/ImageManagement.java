package com.boldijarpaul.eww.service;

import com.boldijarpaul.eww.entities.User;
import com.boldijarpaul.eww.helper.HttpHelper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ImageManagement {

	/* this class will generate the image */
	private static final String HTML = "<!DOCTYPE html>\r\n<html>\r\n<body>\r\n \r\n<canvas id=\"myCanvas\" width=\"500\" height=\"494\" style=\"border:1px solid #000000;\">\r\nYour browser does not support the HTML5 canvas tag.\r\n</canvas>\r\n \r\n<script>\r\nvar img = new Image;\r\nimg.src = \"http://data1.whicdn.com/images/100740366/large.jpg\";\r\n \r\nvar img2= new Image;\r\nimg2.src= \"%url\";\r\n \r\nvar c = document.getElementById(\"myCanvas\");\r\nvar ctx = c.getContext(\"2d\");\r\nctx.fillStyle = \"#FF0000\";\r\nimg.onload = function() {\r\nctx.drawImage(img,0,0);\r\n}\r\nimg2.onload = function() {\r\nctx.drawImage(img2,170,330,100,100);\r\n}\r\n</script>\r\n</body>\r\n</html>";
	private static final String ACCESS_TOKEN = "?access_token=CAAVd9XZBW4lIBAGAH6o2ebN3wS1v4fG68I1ZCIJBgac8NCHH5wZBDwEuZAgwp12WgAD3BjrPGHiUwQtIqMVdZCPuCoFVkLwaaHSv3CyQ47YK5EuuAxxN21OgFHU5mj5jXTmJLBJqoZABKI5ZBJZBywd6hFSOZBjP6dkl7gJwbvGFEm3FBVLfjfxilkGoXIZCEHvoWjWmSYelZCdXLev3mK5NUTy";

	/* this method will return the good image, with the url provided */
	public static String getHtml(String url) {
		return HTML.replace("%url", url);
	}

	public static String createImage(String username) {
		String id = getIdFromUsername(username);
		String rawUrl = getUrlFromId(id);
		String url = HttpHelper.getRedirectedURL(rawUrl);
		return getHtml(url);
	}

	public static String getUrlFromId(String id) {
		return "https://graph.facebook.com/" + id + "/picture?type=large";
	}

	public static String getIdFromUsername(String username) {
		String json = "https://graph.facebook.com/" + username+ACCESS_TOKEN;
		json = HttpHelper.urlToString(json);
		if (json == null)
			return "";
		try {
			User user = new Gson().fromJson(json, User.class);
			return user.getId();
		} catch (JsonSyntaxException e) {
			/* can't parse, return " " */
			return "";
		}
	}

}
