package com.blog.app.service;

import com.blog.app.payload.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getAllPost();

    PostDTO getPostbyId(long id);

    PostDTO update(PostDTO postDTO,long id);

    void deleteByiD(long id);


}
