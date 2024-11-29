package com.careconnect.service;

import com.careconnect.collections.Like;

import com.careconnect.repository.LikeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LikeService {
  @Autowired
  private LikeRepository likeRepository;

  public Like save(Like like) {
    return likeRepository.save(like);
  }

  public List<Like> findByPostId(String postId) {
    return likeRepository.findByPostId(postId);
  }

  public List<Like> findByUserId(String userId) {
    return likeRepository.findByUserId(userId);
  }

  public boolean existsByPostIdAndUserId(String postId, String userId) {
    return likeRepository.existsByPostIdAndUserId(postId, userId);
  }

  public long countByPostId(String postId) {
    return likeRepository.countByPostId(postId);
  }

  public void deleteByPostId(String postId) {
    likeRepository.deleteByPostId(postId);
  }

  public void deleteByPostIdAndUserId(String postId, String userId) {
    likeRepository.deleteByPostIdAndUserId(postId, userId);
  }

}
