package com.h2test.service;

import com.h2test.domain.Author;
import com.h2test.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImplementation implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> read()
    {
        return authorRepository.findAll();

    }

    public Author addAuthor(Author author)
    {
         authorRepository.save(author);
         return authorRepository.findOne(author.getId());
    }


    public List<Author> addItem(Author author){
        authorRepository.save(author);
        return authorRepository.findAll();
    }

    public Author findOne(long id)
    {
        return authorRepository.findOne(id);
    }

}
