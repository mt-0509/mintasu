package model;

import java.io.Serializable;

public class UserBeans implements Serializable {
	private static final long serialVersionUID = 1L;

	private String pass;
	private String name;
	private String comment;

	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
