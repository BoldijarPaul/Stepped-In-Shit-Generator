package com.boldijarpaul.eww.entities;

/* generated with http://pojo.sodhanalibrary.com/Convert */
public class User {
	private String id;

	private String first_name;

	private String name;

	private String link;

	private String last_name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", first_name = " + first_name
				+ ", name = " + name + ", link = " + link + ", last_name = "
				+ last_name + "]";
	}
}
