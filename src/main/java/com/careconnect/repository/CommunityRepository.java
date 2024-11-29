package com.careconnect.repository;

import com.careconnect.collections.Community;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CommunityRepository extends MongoRepository<Community, String> {
  List<Community> findByCommName(String commName);

  List<Community> findByCommLocation(String commLocation);

  List<Community> findByCommNameContaining(String keyword);

  List<Community> findByCommLocationContaining(String keyword);

  List<Community> findByUsersContaining(String userId);

  long countByCommName(String commName);

  long countByCommLocation(String commLocation);

  void deleteByCommId(String commId);

  List<Community> findTop10ByOrderByUsersDesc();

  List<Community> findByCommNameAndCommLocation(String commName, String commLocation);

}