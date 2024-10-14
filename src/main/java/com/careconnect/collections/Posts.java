package com.careconnect.collections;


import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "posts")

public class Posts {

 @Id

 private String postId;

 private String userId;

 private String description;

 private int likes;

 private List<String> comments;

 // Constructors

 public Posts() {

 }

 public Posts(String userId, String description) {

  this.userId = userId;

  this.description = description;

  this.likes = 0;

 }

 // Getters and Setters

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

 public String getDescription() {

  return description;

 }

 public void setDescription(String description) {

  this.description = description;

 }

 public int getLikes() {

  return likes;

 }

 public void setLikes(int likes) {

  this.likes = likes;

 }

 public List<String> getComments() {

  return comments;

 }

 public void setComments(List<String> comments) {

  this.comments = comments;

 }

}