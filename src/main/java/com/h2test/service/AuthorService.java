package com.h2test.service;

import com.h2test.domain.Author;



    public interface AuthorService{
        Iterable<Author> read();
        Author findOne(long id);
        void addItem(Author author);

    }

