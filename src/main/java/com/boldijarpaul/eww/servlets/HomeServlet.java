package com.boldijarpaul.eww.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.boldijarpaul.eww.service.ImageManagement;

@Path("/")
public class HomeServlet {

	/* making the image */
	@GET
	@Path("/{fbname}")
	public String getImage(@PathParam("fbname") String fbname) {
		return ImageManagement.createImage(fbname);
	}

	/* showing message for user to know that he got the URL wrong */
	@GET
	public String getHomeString() {
		return "Hey, you need to add the username from facebook. go to this_url/yourname.example";
	}
}
