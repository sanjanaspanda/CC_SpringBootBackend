package com.careconnect.service;

import com.careconnect.collections.Posts;
import com.careconnect.collections.Comment; // Assuming Comment is a class representing a comment
import com.careconnect.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {
  @Autowired
  private PostRepository postRepository;

  public List<Posts> findByUserId(String userId) {
    return postRepository.findByUserId(userId);
  }

  public List<Posts> findByUserIdIn(List<String> userIds) {
    return postRepository.findByUserIdIn(userIds);
  }

  public List<Posts> findByDescriptionContaining(String keyword) {
    return postRepository.findByDescriptionContaining(keyword);
  }

  public long countByUserId(String userId) {
    return postRepository.countByUserId(userId);
  }

  public void deleteByUserId(String userId) {
    postRepository.deleteByUserId(userId);
  }

  public List<Posts> findByUserIdOrderByPostIdDesc(String userId) {
    return postRepository.findByUserIdOrderByPostIdDesc(userId);
  }

  public List<Posts> findTop10ByOrderByLikesDesc() {
    return postRepository.findTop10ByOrderByLikesDesc();
  }

  public List<Posts> findByUserIdAndLikesGreaterThan(String userId, int likesThreshold) {
    return postRepository.findByUserIdAndLikesGreaterThan(userId, likesThreshold);
  }

  public List<Posts> findByCommentsContaining(String comment) {
    return postRepository.findByCommentsContaining(comment);
  }

  public long countByLikesGreaterThan(int likesThreshold) {
    return postRepository.countByLikesGreaterThan(likesThreshold);
  }

  public List<Posts> findByUserIdAndDescriptionContaining(String userId, String keyword) {
    return postRepository.findByUserIdAndDescriptionContaining(userId, keyword);
  }

  public Posts save(Posts post) {
    return postRepository.save(post);
  }

  public List<Posts> findAll() {
    return postRepository.findAll();
  }

  public void deleteById(String id) {
    postRepository.deleteById(id);
  }

  public Comment addCommentToPost(String postId, Comment comment) {
    Posts post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
    post.getComments().add(comment); // Assuming Posts has a List<Comment> comments
    postRepository.save(post);
    return comment; // Return the added comment
  }

}