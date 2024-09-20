package com.blogging.bloging.service;

import com.blogging.bloging.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post posts, Long userId);
    Post updatePost(Post postsDto, Long postId);
    void deletePost(Long postId);
    List<Post> getAllPost();
    Post getPostById(Long postId);

      /*  List<Post>getPostByCategory(Integer categoryId);
        List<Post>getPostByUsers(Integer userId);
        List<Post>postSearchByKeyword(String keyword);*/

}
