package com.careconnect.service;

import com.careconnect.collections.Message;

import com.careconnect.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MessageService {
  @Autowired
  private MessageRepository messageRepository;
  @Autowired
  private SimpMessagingTemplate messagingTemplate;

  public Message save(Message message) {
    Message savedMessage = messageRepository.save(message); // Broadcast the message to all subscribers of this
                                                            // community
    messagingTemplate.convertAndSend("/topic/community/" + message.getCommId(), savedMessage);
    return savedMessage;
  }

  public void updateMessageStatus(String messageId, Message.MessageStatus status) {
    messageRepository.findById(messageId).ifPresent(message -> {
      message.setStatus(status);
      Message updatedMessage = messageRepository.save(message);
      messagingTemplate.convertAndSend("/topic/community/" + message.getCommId() + "/status", updatedMessage);
    });
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