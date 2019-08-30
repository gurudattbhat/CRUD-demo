package com.h2test.controller;

import com.h2test.domain.Author;
import com.h2test.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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


    @RequestMapping( value = "/", method = RequestMethod.POST )
    public void addData(@RequestBody Author author)
    {
         authorService.addItem(author);
    }

}
