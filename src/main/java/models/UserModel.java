package models;

import com.fasterxml.jackson.annotation.JsonProperty;



public class UserModel {

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("password")
	private String password;

	@JsonProperty("userStatus")
	private int userStatus;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("id")
	private int id;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;
}