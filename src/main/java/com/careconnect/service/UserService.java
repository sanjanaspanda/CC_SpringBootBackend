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

  public Optional<user> updateUser(String id, user user) {
    if (userRepository.existsById(id)) {
      user.setUserId(id); // Assuming user has a setId method
      return Optional.of(userRepository.save(user));
    }
    return Optional.empty();
  }
  
  public void sendFriendRequest(String senderId, String receiverId) {
	  Optional<user> senderUser = getuserByEmail(senderId);
	  Optional<user> receiverUser = getuserByEmail(receiverId);
	  
	  senderUser.ifPresent(sender -> {
	    sender.getSentRequests().add(receiverId);
	    userRepository.save(sender);
	  });
	  
	  receiverUser.ifPresent(receiver -> {
	    receiver.getFriendRequests().add(senderId);
	    userRepository.save(receiver);
	  });
	}
  public void acceptFriendRequest(String userId, String friendId) {
	  Optional<user> user = getuserByEmail(userId);
	  Optional<user> friend = getuserByEmail(friendId);
	  
	  user.ifPresent(u -> {
	    u.getFriends().add(friendId);
	    u.getFriendRequests().remove(friendId);
	    userRepository.save(u);
	  });
	  
	  friend.ifPresent(f -> {
	    f.getFriends().add(userId);
	    f.getSentRequests().remove(userId);
	    userRepository.save(f);
	  });
	}
  public void rejectFriendRequest(String userId, String friendId) {
	  Optional<user> user = getuserByEmail(userId);
	  Optional<user> friend = getuserByEmail(friendId);
	  
	  user.ifPresent(u -> {
	    u.getFriendRequests().remove(friendId);
	    userRepository.save(u);
	  });
	  
	  friend.ifPresent(f -> {
	    f.getSentRequests().remove(userId);
	    userRepository.save(f);
	  });
	}
  public List<user> getAllSentRequests(String userId) {
	  return userRepository.findBySentRequestsContaining(userId);
	}

	public List<user> getAllReceivedRequests(String userId) {
	  return userRepository.findByFriendRequestsContaining(userId);
	}
}