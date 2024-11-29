package com.careconnect.service;

import com.careconnect.collections.News;

import com.careconnect.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Date;

@Service

public class NewsService {
  @Autowired
  private NewsRepository newsRepository;

  public List<News> findByTitle(String title) {
    return newsRepository.findByTitle(title);
  }

  public List<News> findByDescription(String description) {
    return newsRepository.findByDescription(description);
  }

  public List<News> findByShortDescription(String shortDescription) {
    return newsRepository.findByShortDescription(shortDescription);
  }

  public List<News> findByDate(Date date) {
    return newsRepository.findByDate(date);
  }

  public List<News> findByTitleContaining(String keyword) {
    return newsRepository.findByTitleContaining(keyword);
  }

  public List<News> findByDescriptionContaining(String keyword) {
    return newsRepository.findByDescriptionContaining(keyword);
  }

  public List<News> findTop10ByOrderByDateDesc() {
    return newsRepository.findTop10ByOrderByDateDesc();
  }

  public long countByTitle(String title) {
    return newsRepository.countByTitle(title);
  }

  public void deleteById(String id) {
    newsRepository.deleteById(id);
  }

  public List<News> findByTitleOrderByDateDesc(String title) {
    return newsRepository.findByTitleOrderByDateDesc(title);
  }

  public List<News> findTop5ByOrderByDateDesc() {
    return newsRepository.findTop5ByOrderByDateDesc();
  }

  public News save(News news) {
    return newsRepository.save(news);
  }

  public List<News> findAll() {
    return newsRepository.findAll();
  }

}