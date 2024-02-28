package com.ssandyy.blogproject.controller;

import com.ssandyy.blogproject.entity.Post;
import com.ssandyy.blogproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        try{
            Post createPost = postService.savePost(post);
            return ResponseEntity.status(HttpStatus.OK).body(createPost);
        }catch (Exception e){e.printStackTrace();}
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    public ResponseEntity<List<Post>> getPostList(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
