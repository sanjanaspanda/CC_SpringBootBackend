package com.careconnect.collections;
import java.util.Date;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")

public class Message {

  @Id

  private String id;

  private String commId;

  private String sentBy;

  private String message;
  
  private long timestamp;

  // Constructors

  public Message() {

  }

  public Message(String commId, String sentBy, String message) {

    this.commId = commId;

    this.sentBy = sentBy;

    this.message = message;
    
    this.timestamp = new Date().getTime();

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

  public String getSentBy() {

    return sentBy;

  }

  public void setSentBy(String sentBy) {

    this.sentBy = sentBy;

  }

  public String getMessage() {

    return message;

  }

  public void setMessage(String message) {

    this.message = message;

  }

public long getTimestamp() {
	return timestamp;
}

public void setTimestamp(long timestamp) {
	this.timestamp = timestamp;
}

}