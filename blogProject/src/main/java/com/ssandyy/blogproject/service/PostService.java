package com.ssandyy.blogproject.service;

import com.ssandyy.blogproject.entity.Post;

import java.util.List;

public interface PostService {
    Post savePost(Post post);
    public List<Post> getPostList();
}
