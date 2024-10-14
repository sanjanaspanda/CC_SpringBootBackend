package com.careconnect.service;

import com.careconnect.collections.user;
import com.careconnect.repository.UserRepo;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service

public class UserService {

  @Autowired

  private UserRepo userRepository;

  public user createuser(user user) {

    return userRepository.save(user);

  }

  public Optional<user> getuserByEmail(String email) {

    return userRepository.findByEmail(email);

  }

  public List<user> searchusersByName(String name) {

    return userRepository.findByNameContainingIgnoreCase(name);

  }

  public boolean existsByEmail(String email) {

    return userRepository.existsByEmail(email);

  }

  public List<user> getusersByAgeGreaterThan(int age) {

    return userRepository.findByAgeGreaterThan(age);

  }

  public List<user> getusersByAddressContaining(String address) {

    return userRepository.findByAddressContaining(address);

  }

  public List<user> getusersByPincodeStartingWith(String pincode) {

    return userRepository.findByPincodeStartingWith(pincode);

  }

  public List<user> getusersByInterest(String interest) {

    return userRepository.findByInterestsContaining(interest);

  }

  public List<user> getusersByFriend(String friendId) {

    return userRepository.findByFriendsContaining(friendId);

  }

  public List<user> getusersByFriendRequest(String userId) {

    return userRepository.findByFriendRequestsContaining(userId);

  }

  public List<user> getusersBySentRequest(String userId) {

    return userRepository.findBySentRequestsContaining(userId);

  }

  public long countusersByAgeGreaterThan(int age) {

    return userRepository.countByAgeGreaterThan(age);

  }

  public List<user> searchusersByNameAndAge(String name, int age) {

    return userRepository.findByNameContainingIgnoreCaseAndAgeGreaterThan(name, age);

  }

}