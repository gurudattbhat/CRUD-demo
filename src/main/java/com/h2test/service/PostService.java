package com.h2test.service;

import com.h2test.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService{
    public Iterable<Post> list();
    List<Post> addItem(Post post);
//    Post create (Post post);
//    Post read(long id);
//    Post update(long id,Post post);
//    void delete (long id);
}