package com.careconnect.service;

import com.careconnect.collections.Community;

import com.careconnect.repository.CommunityRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CommunityService {

  @Autowired

  private CommunityRepository communityRepository;

  public List<Community> findByCommName(String commName) {

    return communityRepository.findByCommName(commName);

  }

  public List<Community> findByCommLocation(String commLocation) {

    return communityRepository.findByCommLocation(commLocation);

  }

  public List<Community> findByCommNameContaining(String keyword) {

    return communityRepository.findByCommNameContaining(keyword);

  }

  public List<Community> findByCommLocationContaining(String keyword) {

    return communityRepository.findByCommLocationContaining(keyword);

  }

  public List<Community> findByUsersContaining(String userId) {

    return communityRepository.findByUsersContaining(userId);

  }

  public long countByCommName(String commName) {

    return communityRepository.countByCommName(commName);

  }

  public long countByCommLocation(String commLocation) {

    return communityRepository.countByCommLocation(commLocation);

  }

  public void deleteByCommId(String commId) {

    communityRepository.deleteByCommId(commId);

  }

  public List<Community> findTop10ByOrderByUsersDesc() {

    return communityRepository.findTop10ByOrderByUsersDesc();

  }

  public List<Community> findByCommNameAndCommLocation(String commName, String commLocation) {

    return communityRepository.findByCommNameAndCommLocation(commName, commLocation);

  }

  public Community save(Community community) {

    return communityRepository.save(community);

  }

  public List<Community> findAll() {

    return communityRepository.findAll();

  }

}




