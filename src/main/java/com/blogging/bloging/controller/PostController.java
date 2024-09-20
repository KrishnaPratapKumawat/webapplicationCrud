package com.blogging.bloging.controller;

import com.blogging.bloging.model.Post;
import com.blogging.bloging.repo.PostRepo;
import com.blogging.bloging.repo.UserInfoRepo;
import com.blogging.bloging.service.CreateUserData;
import com.blogging.bloging.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    CreateUserData userDataService;
    @Autowired
    PostRepo postRepo;
    @Autowired
    PostServiceImpl postService;

    @PostMapping("/createPost/{userId}")
    public ResponseEntity<Post> createNewPost(@RequestBody Post post, @PathVariable Long userId){
        Post servicePost = this.postService.createPost(post, userId);
        return new ResponseEntity<Post>(servicePost,HttpStatus.CREATED);
    }
    @GetMapping("post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId){
        Post servicePost = this.postService.getPostById( postId);
        return new ResponseEntity<Post>(servicePost,HttpStatus.OK);
    }
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPost(){
        List<Post> allPost = this.postService.getAllPost();
        return new ResponseEntity<List<Post>>(allPost,HttpStatus.OK);
    }
    @PutMapping("/updatePost/{postId}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable Long postId){
        Post servicePost = this.postService.updatePost(post, postId);
        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }
    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId){
        this.postService.deletePost(postId);
        return  ResponseEntity .ok("Post is deleted!!");
    }
}
