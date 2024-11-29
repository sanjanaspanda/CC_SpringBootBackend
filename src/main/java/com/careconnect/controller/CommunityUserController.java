package com.careconnect.controller;

import com.careconnect.service.CommunityUserService;

import com.careconnect.collections.CommunityUser;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/community-users")

public class CommunityUserController {
  @Autowired
  private CommunityUserService communityUserService;

  @GetMapping("/{userId}")
  public ResponseEntity<CommunityUser> getUserById(@PathVariable String userId) {
    CommunityUser user = communityUserService.findByUserId(userId);
    return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
  }

  @GetMapping("/community/{commId}")
  public ResponseEntity<List<CommunityUser>> getUsersByCommunity(@PathVariable String commId) {
    List<CommunityUser> users = communityUserService.findByCommId(commId);
    return ResponseEntity.ok(users);
  }

  @GetMapping("/check")
  public ResponseEntity<Boolean> checkUserInCommunity(@RequestParam String commId, @RequestParam String userId) {
    boolean exists = communityUserService.existsByCommIdAndUserId(commId, userId);
    return ResponseEntity.ok(exists);
  }

  @GetMapping("/count/{commId}")
  public ResponseEntity<Long> getUserCountInCommunity(@PathVariable String commId) {
    long count = communityUserService.countByCommId(commId);
    return ResponseEntity.ok(count);
  }

  @DeleteMapping("/community/{commId}")
  public ResponseEntity<Void> deleteUsersInCommunity(@PathVariable String commId) {
    communityUserService.deleteByCommId(commId);
    return ResponseEntity.noContent().build();
  }

  @PostMapping
  public ResponseEntity<CommunityUser> createCommunityUser(@RequestBody CommunityUser communityUser) {
    CommunityUser savedUser = communityUserService.save(communityUser);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
  }

  @GetMapping
  public ResponseEntity<List<CommunityUser>> getAllCommunityUsers() {
    List<CommunityUser> users = communityUserService.findAll();
    return ResponseEntity.ok(users);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCommunityUser(@PathVariable String id) {
    communityUserService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}