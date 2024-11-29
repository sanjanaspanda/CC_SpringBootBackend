package com.careconnect.collections;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "community_users")

public class CommunityUser {
  @Id
  private String id;
  private String commId;
  private String userId;

  // Constructors
  public CommunityUser() {
  }

  public CommunityUser(String commId, String userId) {
    this.commId = commId;
    this.userId = userId;
  }

  // Getters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCommId() {
    return commId;
  }

  public void setCommId(String commId) {
    this.commId = commId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

}