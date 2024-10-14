package com.careconnect.controller;

import com.careconnect.service.CommunityService;

import com.careconnect.collections.Community;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/community")

public class CommunityController {

  @Autowired

  private CommunityService communityService;

  @PostMapping

  public ResponseEntity<Community> createCommunity(@RequestBody Community community) {

    Community createdCommunity = communityService.save(community);

    return new ResponseEntity<>(createdCommunity, HttpStatus.CREATED);

  }

  @GetMapping

  public ResponseEntity<List<Community>> getAllCommunities() {

    List<Community> communities = communityService.findAll();

    return new ResponseEntity<>(communities, HttpStatus.OK);

  }

  @GetMapping("/search")

  public ResponseEntity<List<Community>> searchCommunities(@RequestParam String keyword) {

    List<Community> searchResults = communityService.findByCommNameContaining(keyword);

    return new ResponseEntity<>(searchResults, HttpStatus.OK);

  }

  @GetMapping("/location")

  public ResponseEntity<List<Community>> getCommunityByLocation(@RequestParam String location) {

    List<Community> communities = communityService.findByCommLocation(location);

    return new ResponseEntity<>(communities, HttpStatus.OK);

  }

  @GetMapping("/popular")

  public ResponseEntity<List<Community>> getPopularCommunities() {

    List<Community> popularCommunities = communityService.findTop10ByOrderByUsersDesc();

    return new ResponseEntity<>(popularCommunities, HttpStatus.OK);

  }

  @DeleteMapping("/{id}")

  public ResponseEntity<Void> deleteCommunity(@PathVariable String id) {

    communityService.deleteByCommId(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }

  @GetMapping("/user/{userId}")

  public ResponseEntity<List<Community>> getCommunitiesByUser(@PathVariable String userId) {

    List<Community> userCommunities = communityService.findByUsersContaining(userId);

    return new ResponseEntity<>(userCommunities, HttpStatus.OK);

  }

}