package com.careconnect.repository;

import com.careconnect.collections.Like;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LikeRepository extends MongoRepository<Like, String> {

  // Find all likes for a specific post

  List<Like> findByPostId(String postId);

  // Find all likes by a specific user

  List<Like> findByUserId(String userId);

  // Check if a user has liked a specific post

  boolean existsByPostIdAndUserId(String postId, String userId);

  // Count the number of likes for a specific post

  long countByPostId(String postId);

  // Delete all likes for a specific post (e.g., when a post is deleted)

  void deleteByPostId(String postId);

  // Delete a specific like (e.g., when a user unlikes a post)

  void deleteByPostIdAndUserId(String postId, String userId);

}