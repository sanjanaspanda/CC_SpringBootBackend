package com.careconnect.collections;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "news")

public class News {
  @Id
  private String id;
  private Date date;
  private String title;
  private String description;
  private String shortDescription;

  // Constructors
  public News() {
  }

  public News(Date date, String title, String description, String shortDescription) {
    this.date = date;
    this.title = title;
    this.description = description;
    this.shortDescription = shortDescription;
  }

  // Getters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

}