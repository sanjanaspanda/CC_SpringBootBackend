package com.careconnect.controller;

import com.careconnect.service.MessageService;
import com.careconnect.service.UserService;
import com.careconnect.collections.Message;
import com.careconnect.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

  @Autowired
  private MessageService messageService;

  @MessageMapping("/message")
  @SendTo("/topic/messages")
  public Message handleMessage(Message message) {
    return messageService.save(message);
  }

  @MessageMapping("/message.status")
  public void updateMessageStatus(String messageId, Message.MessageStatus status) {
    messageService.updateMessageStatus(messageId, status);
  }

  @PostMapping
  public ResponseEntity<Message> createMessage(@RequestBody Message message) {
    Message createdMessage = messageService.save(message);
    return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
  }

  @Autowired
  private UserRepo userService;

  @GetMapping("/conversation/{commId}")
  public ResponseEntity<List<Message>> getMessagesByConversation(@PathVariable String commId) {
    List<Message> messages = messageService.findByCommId(commId);
    messages.forEach(message -> {
      String userName = userService.findById(message.getSentBy()).get().getName();
      message.setUserName(userName);
    });
    return new ResponseEntity<>(messages, HttpStatus.OK);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Message>> getMessagesByUser(@PathVariable String userId) {
    List<Message> messages = messageService.findBySentBy(userId);
    return new ResponseEntity<>(messages, HttpStatus.OK);
  }

  @GetMapping("/conversation/{commId}/after/{timestamp}")
  public ResponseEntity<List<Message>> getMessagesAfterTimestamp(@PathVariable String commId,
      @PathVariable long timestamp) {
    List<Message> messages = messageService.findByCommIdAndTimestampAfter(commId, timestamp);
    return new ResponseEntity<>(messages, HttpStatus.OK);
  }

  @GetMapping("/count/{commId}")
  public ResponseEntity<Long> getMessageCountForConversation(@PathVariable String commId) {
    long count = messageService.countByCommId(commId);
    return new ResponseEntity<>(count, HttpStatus.OK);
  }

  @GetMapping("/latest/{commId}")
  public ResponseEntity<Message> getLatestMessageInConversation(@PathVariable String commId) {
    Message latestMessage = messageService.findLatestInConversation(commId);
    return new ResponseEntity<>(latestMessage, HttpStatus.OK);
  }

  @DeleteMapping("/{commId}")
  public ResponseEntity<Void> deleteConversation(@PathVariable String commId) {
    messageService.deleteByCommId(commId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Message>> searchMessages(@RequestParam String keyword) {
    List<Message> messages = messageService.findByKeyword(keyword);
    return new ResponseEntity<>(messages, HttpStatus.OK);
  }

}
