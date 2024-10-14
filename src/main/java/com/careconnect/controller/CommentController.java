package com.careconnect.controller;

import com.careconnect.service.CommentService;

import com.careconnect.collections.Comment;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/comments")

public class CommentController {

  @Autowired

  private CommentService commentService;

  @PostMapping

  public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {

    Comment createdComment = commentService.save(comment);

    return new ResponseEntity<>(createdComment, HttpStatus.CREATED);

  }

  @GetMapping

  public ResponseEntity<List<Comment>> getAllComments() {

    List<Comment> comments = commentService.findAll();

    return new ResponseEntity<>(comments, HttpStatus.OK);

  }

  @GetMapping("/post/{postId}")

  public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable String postId) {

    List<Comment> comments = commentService.findByPostId(postId);

    return new ResponseEntity<>(comments, HttpStatus.OK);

  }

  @GetMapping("/user/{userId}")

  public ResponseEntity<List<Comment>> getCommentsByUserId(@PathVariable String userId) {

    List<Comment> comments = commentService.findByUserId(userId);

    return new ResponseEntity<>(comments, HttpStatus.OK);

  }

  @DeleteMapping("/post/{postId}")

  public ResponseEntity<Void> deleteCommentsByPostId(@PathVariable String postId) {

    commentService.deleteByPostId(postId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }

}