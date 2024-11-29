package com.careconnect.repository;

import com.careconnect.collections.Message;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MessageRepository extends MongoRepository<Message, String> {
  // Find all messages in a specific conversation
  List<Message> findByCommId(String commId);

  // Find messages sent by a specific user
  List<Message> findBySentBy(String userId);

  // Find messages in a conversation after a certain timestamp
  List<Message> findByCommIdAndTimestampAfter(String commId, long timestamp);

  // Count the number of messages in a conversation
  long countByCommId(String commId);

  // Find the latest message in a conversation
  Message findFirstByCommIdOrderByTimestampDesc(String commId);

  // Delete all messages in a specific conversation
  void deleteByCommId(String commId);

  // Find messages containing a specific keyword
  List<Message> findByMessageContainingIgnoreCase(String keyword);

}
