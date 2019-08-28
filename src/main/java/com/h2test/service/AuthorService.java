package com.h2test.service;

import com.h2test.domain.Author;

import java.util.List;


    public interface AuthorService{
        Iterable<Author> read();
        Author addAuthor(Author author);
        //void delete(long id);
       //Author update(long id,Author author);
        Author findOne(long id);
       // List<Author> findByName(String last_name);
    }

