package com.h2test.service;

import com.h2test.dto.PostDto;
import com.h2test.domain.Post;


import java.util.List;


public interface PostService{
     Iterable<Post> read();
     //List<Post> addItem(Post post);
     void delete(long id);
     Post update(long id,Post post);
     Post findOne(long id);
     List<Post> findByTitleContaining(String title);
     List<Post> addItem(PostDto postDto);
}