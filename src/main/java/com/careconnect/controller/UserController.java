package com.careconnect.controller;

import com.careconnect.service.UserService;

import com.careconnect.collections.user;
import com.careconnect.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;

@RestController

@RequestMapping("/api/users")

public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private UserRepo userRepo;

  @PostMapping
  public ResponseEntity<user> createUser(@RequestBody user user) {
    user createdUser = userService.createuser(user);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<user> getUserByEmail(@PathVariable String email) {
    System.out.println("Inside");
    Optional<user> user = userService.getuserByEmail(email);
    return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  
  @GetMapping
  public ResponseEntity<List<user>> getAllUsers() {
    System.out.println("Inside");
    List<user> users = userRepo.findAll();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<user> updateUser(@PathVariable String id, @RequestBody user user) {
    Optional<user> updatedUser = userService.updateUser(id, user);
    return updatedUser.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/search")
  public ResponseEntity<List<user>> searchUsersByName(@RequestParam String name) {
    List<user> users = userService.searchusersByName(name);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/exists/email/{email}")
  public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
    boolean exists = userService.existsByEmail(email);
    return new ResponseEntity<>(exists, HttpStatus.OK);
  }

  @GetMapping("/age/{age}")
  public ResponseEntity<List<user>> getUsersByAgeGreaterThan(@PathVariable int age) {
    List<user> users = userService.getusersByAgeGreaterThan(age);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/address")
  public ResponseEntity<List<user>> getUsersByAddressContaining(@RequestParam String address) {
    List<user> users = userService.getusersByAddressContaining(address);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/pincode")
  public ResponseEntity<List<user>> getUsersByPincodeStartingWith(@RequestParam String pincode) {
    List<user> users = userService.getusersByPincodeStartingWith(pincode);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/interest")
  public ResponseEntity<List<user>> getUsersByInterest(@RequestParam String interest) {
    List<user> users = userService.getusersByInterest(interest);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/friend/{friendId}")
  public ResponseEntity<List<user>> getUsersByFriend(@PathVariable String friendId) {
    List<user> users = userService.getusersByFriend(friendId);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/friendRequest/{userId}")
  public ResponseEntity<List<user>> getUsersByFriendRequest(@PathVariable String userId) {
    List<user> users = userService.getusersByFriendRequest(userId);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/sentRequest/{userId}")
  public ResponseEntity<List<user>> getUsersBySentRequest(@PathVariable String userId) {
    List<user> users = userService.getusersBySentRequest(userId);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/count/age/{age}")
  public ResponseEntity<Long> countUsersByAgeGreaterThan(@PathVariable int age) {
    long count = userService.countusersByAgeGreaterThan(age);
    return new ResponseEntity<>(count, HttpStatus.OK);
  }

  @GetMapping("/search/nameAndAge")
  public ResponseEntity<List<user>> searchUsersByNameAndAge(@RequestParam String name, @RequestParam int age) {
    List<user> users = userService.searchusersByNameAndAge(name, age);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }
  @PostMapping("/send-request/{senderId}/{receiverId}")
  public ResponseEntity<Void> sendFriendRequest(@PathVariable String senderId, @PathVariable String receiverId) {
    userService.sendFriendRequest(senderId, receiverId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/accept-request/{userId}/{friendId}")
  public ResponseEntity<Void> acceptFriendRequest(@PathVariable String userId, @PathVariable String friendId) {
    userService.acceptFriendRequest(userId, friendId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/reject-request/{userId}/{friendId}")
  public ResponseEntity<Void> rejectFriendRequest(@PathVariable String userId, @PathVariable String friendId) {
    userService.rejectFriendRequest(userId, friendId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/sent-requests/{userId}")
  public ResponseEntity<List<user>> getAllSentRequests(@PathVariable String userId) {
    List<user> sentRequests = userService.getAllSentRequests(userId);
    return new ResponseEntity<>(sentRequests, HttpStatus.OK);
  }

  @GetMapping("/received-requests/{userId}")
  public ResponseEntity<List<user>> getAllReceivedRequests(@PathVariable String userId) {
    List<user> receivedRequests = userService.getAllReceivedRequests(userId);
    return new ResponseEntity<>(receivedRequests, HttpStatus.OK);
  }

}
