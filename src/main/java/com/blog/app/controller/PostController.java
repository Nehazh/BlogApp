package com.blog.app.controller;


import com.blog.app.payload.PostDTO;
import com.blog.app.repository.PostRepository;
import com.blog.app.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")

public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){

        return new ResponseEntity<PostDTO>(postService.createPost(postDTO), HttpStatus.CREATED);
    }
    //api.post - url
// Status code 201 - created

    //update Post by restapi

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostDTO> updatePost (@RequestBody PostDTO postDTO, @PathVariable (name = "id") long id){
        PostDTO postResponse = postService.update(postDTO,id);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }




}
