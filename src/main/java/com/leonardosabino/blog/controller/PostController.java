package com.leonardosabino.blog.controller;

import com.leonardosabino.blog.model.dto.PostDTO;
import com.leonardosabino.blog.service.PostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import java.util.List;

@RestController
@RequestMapping(path = "v1/post", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "PostController", tags = "PostController")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    @ApiOperation(value = "Find all posts")
    public List<PostDTO> findpost() {
        return postService.findpost();
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Find post by ID")
    public PostDTO findpostById(@PathVariable String id) {
        return postService.findpostById(id);
    }

    @PostMapping
    @ApiOperation(value = "Create a new post")
    public PostDTO savepost(@Validated @RequestBody PostDTO postEntity) {
        return postService.savepost(postEntity);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete a existent post")
    public void deletepost(@PathVariable String id) {
        postService.deletepost(id);
    }

    @DeleteMapping
    @ApiOperation(value = "Delete all existent posts")
    public void deletepost() {
        postService.deletepost();
    }
}
