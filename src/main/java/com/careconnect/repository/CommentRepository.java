package com.careconnect.repository;

import com.careconnect.collections.Comment;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CommentRepository extends MongoRepository<Comment, String> {

  List<Comment> findByPostId(String postId);

  List<Comment> findByUserId(String userId);

  void deleteByPostId(String postId);

}

