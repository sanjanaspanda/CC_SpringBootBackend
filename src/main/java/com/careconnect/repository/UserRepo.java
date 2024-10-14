package com.careconnect.repository;

import com.careconnect.collections.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository

public interface UserRepo extends MongoRepository<user, String> {

	 Optional<user> findByEmail(String email);

	  List<user> findByNameContainingIgnoreCase(String name);

	  boolean existsByEmail(String email);

	  List<user> findByAgeGreaterThan(int age);

	  List<user> findByAddressContaining(String address);

	  List<user> findByPincodeStartingWith(String pincode);

	  List<user> findByInterestsContaining(String interest);

	  List<user> findByFriendsContaining(String friendId);

	  List<user> findByFriendRequestsContaining(String userId);

	  List<user> findBySentRequestsContaining(String userId);

	  long countByAgeGreaterThan(int age);

	  List<user> findByNameContainingIgnoreCaseAndAgeGreaterThan(String name, int age);
}