package com.careconnect.collections;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_posts")

public class UserPost {
  @Id
  private String id;
  private String userId;
  private String postId;

  // Constructors
  public UserPost() {
  }

  public UserPost(String userId, String postId) {
    this.userId = userId;
    this.postId = postId;
  }

  // Getters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

}
