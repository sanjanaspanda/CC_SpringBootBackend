package com.careconnect.collections;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "likes")

public class Like {
  @Id
  private String id;
  private String postId;
  private String userId;

  // Constructors
  public Like() {
  }

  public Like(String postId, String userId) {
    this.postId = postId;
    this.userId = userId;
  }

  // Getters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

}