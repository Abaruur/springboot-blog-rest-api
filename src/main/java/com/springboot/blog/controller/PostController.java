package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    //Injecting interface which makes implementation as a loose coupling.
    private PostService postService;
// if we are configuring class as spring bean and has one constructor we can omit the @Autowire
    //annotation.
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //Create (rest-end point) blog post rest api

    @PostMapping
    //Spring provides response entity class. This class represents a whole Http response,
    //such as HttpStatus,Headers, body,
    //@RequestBody will convert JSON into a java object
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get all posts rest api
    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

}
