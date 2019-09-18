package com.h2test.controller;
import com.h2test.dto.PostDto;
import com.h2test.domain.Post;
import com.h2test.exception.PostNotFoundException;
import com.h2test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;



    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Iterable<Post> read()
    {
        return postService.read();
    }


    @RequestMapping( value = "/", method = RequestMethod.POST )
    public Post addData(@RequestBody PostDto postDto)
    {
        return postService.addItem(postDto);
    }



    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable(value="id") long id)
    {
        postService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Post update(@PathVariable (value ="id") long id, @RequestBody Post post)
    {
        return postService.update(id,post);
    }

    @RequestMapping (value="/{id}", method= RequestMethod.GET)
    public Post findOne(@PathVariable(value="id") long id)
    {
         if(postService.getOne(id)==null)
             throw new PostNotFoundException("Post does not exists");
         else
             return postService.getOne(id);


    }

    @RequestMapping(value="/search/{title}",method=RequestMethod.GET)
    public List<Post> findByName(@PathVariable String title)
    {
        return postService.findByTitleContaining(title);
    }
}