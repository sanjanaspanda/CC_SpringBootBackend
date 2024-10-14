package com.careconnect.repository;
import com.careconnect.collections.News;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Date;

@Repository

public interface NewsRepository extends MongoRepository<News, String> {

  List<News> findByTitle(String title);

  List<News> findByDescription(String description);

  List<News> findByShortDescription(String shortDescription);

  List<News> findByDate(Date date);

  List<News> findByTitleContaining(String keyword);

  List<News> findByDescriptionContaining(String keyword);

  List<News> findTop10ByOrderByDateDesc();

  long countByTitle(String title);

  void deleteById(String id);

  List<News> findByTitleOrderByDateDesc(String title);

  List<News> findTop5ByOrderByDateDesc();

}

