package com.leonardosabino.blog.repository;

import com.leonardosabino.blog.model.entity.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends MongoRepository<PostEntity, String>, PagingAndSortingRepository<PostEntity, String> {
}
