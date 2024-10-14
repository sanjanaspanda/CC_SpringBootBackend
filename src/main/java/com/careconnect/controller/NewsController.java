package com.careconnect.controller;

import com.careconnect.service.NewsService;

import com.careconnect.collections.News;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Date;

@RestController

@RequestMapping("/api/news")

public class NewsController {

  @Autowired

  private NewsService newsService;

  @PostMapping

  public ResponseEntity<News> createNews(@RequestBody News news) {

    News createdNews = newsService.save(news);

    return new ResponseEntity<>(createdNews, HttpStatus.CREATED);

  }

  @GetMapping

  public ResponseEntity<List<News>> getAllNews() {

    List<News> newsList = newsService.findAll();

    return new ResponseEntity<>(newsList, HttpStatus.OK);

  }

  @GetMapping("/recent")

  public ResponseEntity<List<News>> getRecentNews() {

    List<News> recentNews = newsService.findTop10ByOrderByDateDesc();

    return new ResponseEntity<>(recentNews, HttpStatus.OK);

  }

  @GetMapping("/search")

  public ResponseEntity<List<News>> searchNews(@RequestParam String keyword) {

    List<News> searchResults = newsService.findByTitleContaining(keyword);

    return new ResponseEntity<>(searchResults, HttpStatus.OK);

  }

  @DeleteMapping("/{id}")

  public ResponseEntity<Void> deleteNews(@PathVariable String id) {

    newsService.deleteById(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }

  @GetMapping("/date")

  public ResponseEntity<List<News>> getNewsByDate(@RequestParam Date date) {

    List<News> newsByDate = newsService.findByDate(date);

    return new ResponseEntity<>(newsByDate, HttpStatus.OK);

  }

}

