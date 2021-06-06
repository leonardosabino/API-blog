package com.leonardosabino.blog.service;

import com.leonardosabino.blog.exception.NotFoundException;
import com.leonardosabino.blog.model.dto.PostDTO;
import com.leonardosabino.blog.model.entity.PostEntity;
import com.leonardosabino.blog.model.mapper.Mapper;
import com.leonardosabino.blog.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private Mapper mapper;

    public List<PostDTO> findPost() {
        return mapper.mapList(postRepository.findAll(), PostDTO.class);
    }

    public PostDTO findPostById(String id) {
        return mapper.map(postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Key %s not found", id))), PostDTO.class);
    }

    public PostDTO savePost(PostDTO postDTO) {
        log.info("registering post {}", postDTO.getTitle());

        PostEntity postEntity = mapper.map(postDTO, PostEntity.class);
        return mapper.map(postRepository.save(postEntity), PostDTO.class);
    }

    public void deletePost(String id) {
        log.info("deleting key {}", id);
        postRepository.deleteById(id);
    }

    public void deletePost() {
        log.info("deleting all keys");
        postRepository.deleteAll();
    }
}
