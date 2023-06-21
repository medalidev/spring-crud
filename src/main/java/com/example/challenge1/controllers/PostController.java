package com.example.challenge1.controllers;

import com.example.challenge1.entites.Post;
import com.example.challenge1.entites.User;
import com.example.challenge1.reponses.messageResponse;
import com.example.challenge1.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService  postService;

    @PostMapping("/new")
    public Post addPost(@RequestBody Post post){
        return postService.addNewPost(post);
    }

    @GetMapping("/all")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost( @PathVariable Long id, @RequestBody Post post){
        return postService.updatePostById(id,post);
    }
    @DeleteMapping("/{id}")
    public messageResponse deletePost(@PathVariable Long id){
        return postService.deletePostById(id);
    }
}
