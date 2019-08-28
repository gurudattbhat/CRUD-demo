package com.h2test.Controller;

import com.h2test.domain.Post;
import com.h2test.service.PostService;
import com.h2test.service.PostServiceImpl;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/post")
public class HomeController {

    private PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Iterable<Post> list(){
        return postService.list();
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public List<Post> addData(@RequestBody Post post){
        return postService.addItem(post);
    }


//    @RequestMapping( value = "/", method = RequestMethod.POST )
//    public Post create(@RequestBody Post post){
//        return postService.create(post);
//    }
//
//    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
//    public Post read(@PathVariable(value="id") long id){
//        return postService.read(id);
//    }
//
//    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
//    public Post update(@PathVariable(value="id") long id, @RequestBody Post post){
//        return postService.update(id,post);
//    }
//
//    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
//    public void delete(@PathVariable(value="id") int id){
//        postService.delete(id);
//    }


}