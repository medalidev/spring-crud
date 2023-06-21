package com.example.challenge1.services;

import com.example.challenge1.entites.Post;
import com.example.challenge1.entites.User;
import com.example.challenge1.reponses.messageResponse;
import com.example.challenge1.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post  getPostById(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Post addNewPost(Post post){
        return postRepository.save(post);
    }

    public Post updatePostById(Long id, Post post){
        post.setId(id);
        return postRepository.save(post);
    }

    public messageResponse deletePostById(Long id){
        postRepository.deleteById(id);
        return new messageResponse("Post deleted successfully!");
    }
}
