package com.blog.app.controller;

import com.blog.app.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    private PostService postService;

    public DeleteController(PostService postService) {
        this.postService = postService;
    }

    @DeleteMapping("api/posts/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") long id){
        postService.deleteByiD(id);
        return new ResponseEntity<>("Deleted SuccesfuLly",HttpStatus.OK);


    }
}
