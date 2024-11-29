package com.careconnect.repository;

import com.careconnect.collections.Posts;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PostRepository extends MongoRepository<Posts, String> {
  List<Posts> findByUserId(String userId);

  List<Posts> findByUserIdIn(List<String> userIds);

  List<Posts> findByDescriptionContaining(String keyword);

  long countByUserId(String userId);

  void deleteByUserId(String userId);

  List<Posts> findByUserIdOrderByPostIdDesc(String userId);

  List<Posts> findTop10ByOrderByLikesDesc();

  List<Posts> findByUserIdAndLikesGreaterThan(String userId, int likesThreshold);

  List<Posts> findByCommentsContaining(String comment);

  long countByLikesGreaterThan(int likesThreshold);

  List<Posts> findByUserIdAndDescriptionContaining(String userId, String keyword);

}