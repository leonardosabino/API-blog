package com.leonardosabino.blog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends MongoRepository<PostRepository, String>, PagingAndSortingRepository<PostRepository, String> {
}
