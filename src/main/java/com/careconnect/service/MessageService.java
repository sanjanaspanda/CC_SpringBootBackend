package com.careconnect.service;

import com.careconnect.collections.Message;

import com.careconnect.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MessageService {

  @Autowired

  private MessageRepository messageRepository;

  public Message save(Message message) {

    return messageRepository.save(message);

  }

  public List<Message> findByCommId(String commId) {

    return messageRepository.findByCommId(commId);

  }

  public List<Message> findBySentBy(String userId) {

    return messageRepository.findBySentBy(userId);

  }

  public List<Message> findByCommIdAndTimestampAfter(String commId, long timestamp) {

    return messageRepository.findByCommIdAndTimestampAfter(commId, timestamp);

  }

  public long countByCommId(String commId) {

    return messageRepository.countByCommId(commId);

  }

  public Message findLatestInConversation(String commId) {

    return messageRepository.findFirstByCommIdOrderByTimestampDesc(commId);

  }

  public void deleteByCommId(String commId) {

    messageRepository.deleteByCommId(commId);

  }

  public List<Message> findByKeyword(String keyword) {

    return messageRepository.findByMessageContainingIgnoreCase(keyword);

  }

}