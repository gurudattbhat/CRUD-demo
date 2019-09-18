package com.h2test.controller;

import com.h2test.domain.Author;
import com.h2test.domain.Post;
import com.h2test.exception.AuthorNotFoundException;
import com.h2test.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController {
    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value="/",method= RequestMethod.GET)
    public Iterable<Author> read()
    {
        return authorService.read();
    }



    @RequestMapping (value="/findUser/{username}", method= RequestMethod.GET)
    UserDetails loadUserByUsername(@PathVariable (value="username") String username)
    {
        if (authorService.loadUserByUsername(username)==null)
            throw new AuthorNotFoundException("Author Not Found");
        return authorService.loadUserByUsername(username);
    }

    @RequestMapping (value="/getPosts/{id}", method= RequestMethod.GET)
    List<Post> getAllPosts(@PathVariable (value="id") long id)
    {
        return authorService.getposts(id);
    }


    @RequestMapping (value="/{id}", method= RequestMethod.GET)
    Author findOne(@PathVariable (value="id") long id)
    {
        if (authorService.findOne(id)==null)
            throw new AuthorNotFoundException("Author Not Found");
        return authorService.findOne(id);
    }

}