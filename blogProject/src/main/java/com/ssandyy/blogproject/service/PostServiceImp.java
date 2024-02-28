package com.ssandyy.blogproject.service;

import com.ssandyy.blogproject.entity.Post;
import com.ssandyy.blogproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post) {
        post.setViewCount(0);
        post.setLikeCount(0);
        post.setDate(new Date());

        return postRepository.save(post);
    }

    public List<Post> getPostList(){
        return postRepository.findAll();
    }
}
