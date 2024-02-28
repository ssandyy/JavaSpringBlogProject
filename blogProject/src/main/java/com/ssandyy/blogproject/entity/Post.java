package com.ssandyy.blogproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(length = 5000)
    private String content;
    private String author;
    private String image;
    private Date date;
    private int viewCount;
    private int likeCount;
    private List<String> tags;
}
