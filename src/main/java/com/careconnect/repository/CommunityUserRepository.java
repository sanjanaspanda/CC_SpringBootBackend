package com.careconnect.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.careconnect.collections.CommunityUser;

import java.util.List;

public interface CommunityUserRepository extends MongoRepository<CommunityUser, String> {

  // Find a user by their userId

  CommunityUser findByUserId(String userId);

  // Find all users in a specific community

  List<CommunityUser> findByCommId(String commId);

  // Check if a user is part of a specific community

  boolean existsByCommIdAndUserId(String commId, String userId);

  // Count the number of users in a community

  long countByCommId(String commId);

  // Delete all users from a specific community

  void deleteByCommId(String commId);

}

