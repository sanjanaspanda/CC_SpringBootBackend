package com.careconnect.controller;

import com.careconnect.service.PostService;
import com.careconnect.collections.Posts;
import com.careconnect.repository.UserRepo;
import com.careconnect.collections.Comment; // Assuming Comment is a class representing a comment

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/posts")

public class PostController {
  @Autowired
  private PostService postService;
  @Autowired
  private UserRepo userRepo;

  @PostMapping
  public ResponseEntity<Posts> createPost(@RequestBody Posts post) {
    Posts createdPost = postService.save(post);
    return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Posts>> getPostsByUser(@PathVariable String userId) {
    List<Posts> posts = postService.findByUserId(userId);
    posts.forEach((post) -> {
      String userName = userRepo.findById(post.getUserId()).get().getName();
      post.setUserName(userName);
    });
    return new ResponseEntity<>(posts, HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Posts>> searchPosts(@RequestParam String keyword) {
    List<Posts> posts = postService.findByDescriptionContaining(keyword);
    return new ResponseEntity<>(posts, HttpStatus.OK);
  }

  @GetMapping("/trending")
  public ResponseEntity<List<Posts>> getTrendingPosts() {
    List<Posts> trendingPosts = postService.findTop10ByOrderByLikesDesc();
    return new ResponseEntity<>(trendingPosts, HttpStatus.OK);
  }

  @DeleteMapping("/{postId}")
  public ResponseEntity<Void> deletePost(@PathVariable String postId) {
    postService.deleteById(postId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/user/{userId}/count")
  public ResponseEntity<Long> countPostsByUser(@PathVariable String userId) {
    long count = postService.countByUserId(userId);
    return new ResponseEntity<>(count, HttpStatus.OK);
  }

  @PostMapping("/{postId}/comments")
  public ResponseEntity<Comment> addComment(@PathVariable String postId, @RequestBody Comment comment) {
    Comment createdComment = postService.addCommentToPost(postId, comment);
    // PostService
    return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
  }

}
