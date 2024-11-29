package com.careconnect.service;

import com.careconnect.collections.CommunityUser;

import com.careconnect.repository.CommunityUserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CommunityUserService {
  @Autowired
  private CommunityUserRepository communityUserRepository;

  public CommunityUser findByUserId(String userId) {
    return communityUserRepository.findByUserId(userId);
  }

  public List<CommunityUser> findByCommId(String commId) {
    return communityUserRepository.findByCommId(commId);
  }

  public boolean existsByCommIdAndUserId(String commId, String userId) {
    return communityUserRepository.existsByCommIdAndUserId(commId, userId);
  }

  public long countByCommId(String commId) {
    return communityUserRepository.countByCommId(commId);
  }

  public void deleteByCommId(String commId) {
    communityUserRepository.deleteByCommId(commId);
  }

  public CommunityUser save(CommunityUser communityUser) {
    return communityUserRepository.save(communityUser);
  }

  public List<CommunityUser> findAll() {
    return communityUserRepository.findAll();
  }

  public void deleteById(String id) {
    communityUserRepository.deleteById(id);
  }

}