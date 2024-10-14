package com.careconnect.controller;

import com.careconnect.service.MessageService;

import com.careconnect.collections.Message;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/messages")

public class MessageController {

  @Autowired

  private MessageService messageService;

  @PostMapping

  public ResponseEntity<Message> createMessage(@RequestBody Message message) {

    Message createdMessage = messageService.save(message);

    return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);

  }

  @GetMapping("/conversation/{commId}")

  public ResponseEntity<List<Message>> getMessagesByConversation(@PathVariable String commId) {

    List<Message> messages = messageService.findByCommId(commId);

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

