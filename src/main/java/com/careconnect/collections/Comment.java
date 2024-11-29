package com.careconnect.collections;

public class Comment {
  private String id;
  private String userId;
  private String comment;

  // Constructors
  public Comment() {
  }

  public Comment(String postId, String userId, String comment) {
    this.userId = userId;
    this.comment = comment;
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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

}
