package com.blog.app.controller;


import com.blog.app.payload.PostDTO;
import com.blog.app.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GetController {
    private PostService postService;

    public GetController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/posts")
    public List<PostDTO> getAllpost() {
        return postService.getAllPost();
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<PostDTO>(postService.getPostbyId(id), HttpStatus.OK);
    }
}
