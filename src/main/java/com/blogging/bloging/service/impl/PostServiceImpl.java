package com.blogging.bloging.service.impl;

import com.blogging.bloging.model.Post;
import com.blogging.bloging.model.UserData;
import com.blogging.bloging.repo.PostRepo;
import com.blogging.bloging.repo.UserInfoRepo;
import com.blogging.bloging.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    UserInfoRepo userInfoRepo;
    @Autowired
    PostRepo postRepo;
    @Override
    public Post createPost(Post posts, Long userId) {
        UserData userData = this.userInfoRepo.findById(userId).orElseThrow();
        posts.setUserData(userData);
        posts.setCurrentDate(new Date());
        posts.setPostImageName("default.png");
        Post save = this.postRepo.save(posts);
        return save;
    }

    @Override
    public Post updatePost(Post posts, Long postId) {
        Post postData = this.postRepo.findById(postId).orElseThrow();
        postData.setPostContent(posts.getPostContent());
        postData.setPostTitle(posts.getPostTitle());
        Post update = this.postRepo.save(posts);
        return update;
    }

    @Override
    public void deletePost(Long postId) {
        Post post = this.postRepo.findById(postId).orElseThrow();
        if (!post.isDeletePostId()){
            post.setDeletePostId(true);
            this.postRepo.save(post);
        }
    }

    @Override
    public List<Post> getAllPost() {
        List<Post> postRepoAll = this.postRepo.findAll();
        return postRepoAll.stream()
                .filter(post -> !post.isDeletePostId()) // Assuming isDelete() is a method in UserData
                .collect(Collectors.toList());
    }

    @Override
    public Post getPostById(Long postId) {
        Post post = this.postRepo.findById(postId).orElseThrow();
        if (!post.isDeletePostId()){
            return post;
        }else {
            return null;
        }
    }
}
