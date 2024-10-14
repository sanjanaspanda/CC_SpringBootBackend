package com.careconnect.collections;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "users")
public class user {

	  @Id
	  private String userId;
	  private String email;
	  private String password;
	  private int age;
	  private String address;
	  private String name;

	  private String pincode;

	  private List<String> interests;

	  private List<String> friends;

	  private List<String> friendRequests;

	  private List<String> sentRequests;

	  // Constructors

	  public user() {

	  }

	  public user(String email, String password, int age, String address, String name, String pincode) {

	    this.email = email;

	    this.password = password;

	    this.age = age;

	    this.address = address;

	    this.name = name;

	    this.pincode = pincode;

	  }

	  // Getters and Setters

	  public String getUserId() {

	    return userId;

	  }

	  public void setUserId(String userId) {

	    this.userId = userId;

	  }

	  public String getEmail() {

	    return email;

	  }

	  public void setEmail(String email) {

	    this.email = email;

	  }

	  public String getPassword() {

	    return password;

	  }

	  public void setPassword(String password) {

	    this.password = password;

	  }

	  public int getAge() {

	    return age;

	  }

	  public void setAge(int age) {

	    this.age = age;

	  }

	  public String getAddress() {

	    return address;

	  }

	  public void setAddress(String address) {

	    this.address = address;

	  }

	  public String getName() {

	    return name;

	  }

	  public void setName(String name) {

	    this.name = name;

	  }

	  public String getPincode() {

	    return pincode;

	  }

	  public void setPincode(String pincode) {

	    this.pincode = pincode;

	  }

	  public List<String> getInterests() {

	    return interests;

	  }

	  public void setInterests(List<String> interests) {

	    this.interests = interests;

	  }

	  public List<String> getFriends() {

	    return friends;

	  }

	  public void setFriends(List<String> friends) {

	    this.friends = friends;

	  }

	  public List<String> getFriendRequests() {

	    return friendRequests;

	  }

	  public void setFriendRequests(List<String> friendRequests) {

	    this.friendRequests = friendRequests;

	  }

	  public List<String> getSentRequests() {

	    return sentRequests;

	  }

	  public void setSentRequests(List<String> sentRequests) {

	    this.sentRequests = sentRequests;

	  }

	}

