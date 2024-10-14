package com.careconnect.collections;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "communities")

public class Community {

  @Id

  private String commId;

  private String commName;

  private String commLocation;

  private List<String> messages;

  private List<String> users;

  // Constructors

  public Community() {

  }

  public Community(String commName, String commLocation) {

    this.commName = commName;

    this.commLocation = commLocation;

  }

  // Getters and Setters

  public String getCommId() {

    return commId;

  }

  public void setCommId(String commId) {

    this.commId = commId;

  }

  public String getCommName() {

    return commName;

  }

  public void setCommName(String commName) {

    this.commName = commName;

  }

  public String getCommLocation() {

    return commLocation;

  }

  public void setCommLocation(String commLocation) {

    this.commLocation = commLocation;

  }

  public List<String> getMessages() {

    return messages;

  }

  public void setMessages(List<String> messages) {

    this.messages = messages;

  }

  public List<String> getUsers() {

    return users;

  }

  public void setUsers(List<String> users) {

    this.users = users;

  }

}

