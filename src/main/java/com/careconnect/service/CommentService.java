package com.careconnect.service;

import com.careconnect.collections.Comment;

import com.careconnect.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CommentService {

  @Autowired

  private CommentRepository commentRepository;

  public Comment save(Comment comment) {

    return commentRepository.save(comment);

  }

  public List<Comment> findByPostId(String postId) {

    return commentRepository.findByPostId(postId);

  }

  public List<Comment> findByUserId(String userId) {

    return commentRepository.findByUserId(userId);

  }

  public void deleteByPostId(String postId) {

    commentRepository.deleteByPostId(postId);

  }

  public List<Comment> findAll() {

    return commentRepository.findAll();

  }

}

