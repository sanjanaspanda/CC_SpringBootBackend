package com.careconnect.controller;

import com.careconnect.service.LikeService;

import com.careconnect.collections.Like;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/likes")

public class LikeController {

  @Autowired

  private LikeService likeService;

  @PostMapping

  public ResponseEntity<Like> createLike(@RequestBody Like like) {

    Like createdLike = likeService.save(like);

    return new ResponseEntity<>(createdLike, HttpStatus.CREATED);

  }

  @GetMapping("/post/{postId}")

  public ResponseEntity<List<Like>> getLikesByPostId(@PathVariable String postId) {

    List<Like> likes = likeService.findByPostId(postId);

    return new ResponseEntity<>(likes, HttpStatus.OK);

  }

  @GetMapping("/user/{userId}")

  public ResponseEntity<List<Like>> getLikesByUserId(@PathVariable String userId) {

    List<Like> likes = likeService.findByUserId(userId);

    return new ResponseEntity<>(likes, HttpStatus.OK);

  }

  @GetMapping("/count/{postId}")

  public ResponseEntity<Long> getLikeCountForPost(@PathVariable String postId) {

    long count = likeService.countByPostId(postId);

    return new ResponseEntity<>(count, HttpStatus.OK);

  }

  @DeleteMapping("/{postId}/{userId}")

  public ResponseEntity<Void> deleteLike(@PathVariable String postId, @PathVariable String userId) {

    likeService.deleteByPostIdAndUserId(postId, userId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }

  @GetMapping("/exists/{postId}/{userId}")

  public ResponseEntity<Boolean> checkLikeExists(@PathVariable String postId, @PathVariable String userId) {

    boolean exists = likeService.existsByPostIdAndUserId(postId, userId);

    return new ResponseEntity<>(exists, HttpStatus.OK);

  }

}
