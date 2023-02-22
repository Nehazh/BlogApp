package com.blog.app.service.Impl;

import com.blog.app.entity.Post;
import com.blog.app.exception.ResourceNotFound;
import com.blog.app.payload.PostDTO;
import com.blog.app.repository.PostRepository;
import com.blog.app.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//This shows this is a service Class

public class PostServiceImpl implements PostService {
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //Construction based Dependency injection
    private PostRepository postRepository;


    @Override
    public PostDTO createPost(PostDTO postDTO) {
        //Convert Dto to entity
        Post post = maptoEntity(postDTO);

        //We are calling repository to save the entity into data object
        Post newpost = postRepository.save(post);

        //convert entity to DTO
        PostDTO postResponse = mapToDto(newpost);
          return postResponse;
    }

    @Override
    public List<PostDTO> getAllPost() {

        List<Post> posts = postRepository.findAll();
        //To convert List of Post to List of PostDTO
        //Stream API of java 8
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostbyId(long id) {
        //find by id by post repo
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("post","id",id));
        return mapToDto(post);
    }

    @Override
    public PostDTO update(PostDTO postDTO, long id) {
        //get post by id
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("post","id",id));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        Post updatePost = postRepository.save(post);
        return mapToDto(post);
    }

    @Override
    public void deleteByiD(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("post","id",id));
        postRepository.delete(post);


    }

    //Convert DTO TO ENTITY
    private Post maptoEntity(PostDTO postDTO){
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        return post;
    }
    //convert Entity to DTO
    private PostDTO mapToDto(Post post){
        PostDTO postResponse = new PostDTO();
        postResponse.setTitle(post.getTitle());
        postResponse.setId(post.getId());
        postResponse.setDescription(post.getDescription());
        postResponse.setContent(post.getContent());
        return postResponse;

    }


}
