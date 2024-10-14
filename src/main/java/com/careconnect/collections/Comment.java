package com.careconnect.collections;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")

public class Comment {

  @Id

  private String id;

  private String postId;

  private String userId;

  private String comment;

  // Constructors

  public Comment() {

  }

  public Comment(String postId, String userId, String comment) {

    this.postId = postId;

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

  public String getComment() {

    return comment;

  }

  public void setComment(String comment) {

    this.comment = comment;

  }

}

