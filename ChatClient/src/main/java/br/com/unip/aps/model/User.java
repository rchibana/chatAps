package br.com.unip.aps.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author win7
 *
 */
public class User {

	@NotNull
	@Size(max=20, message="The name field can not contain more than 20 characters")
	private String name;

	public User(){
		this.name = "";
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getClearName(){
		return this.name.replaceAll(" ", "");
	}
	
}
