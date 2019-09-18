package com.h2test.repository;


import com.h2test.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.h2test.domain.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleContaining(String title);
    Post findPostById(long id);



}

