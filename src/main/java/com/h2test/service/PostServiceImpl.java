package com.h2test.service;

import javax.transaction.Transactional;
import com.h2test.domain.Post;
import com.h2test.repository.AuthorRepository;
import com.h2test.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Post> read() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> addItem(Post post){
        postRepository.save(post);
        return postRepository.findAll();
    }

    @Override
    public void delete(long id)
    {
        postRepository.delete(id);
    }


    @Override
    public Post update(long id,Post Update)
    {
        Post post=postRepository.findOne(id);
        if(Update.getTitle()!=null)
        {
            post.setTitle(Update.getTitle());
        }
        return postRepository.save(post);
    }

    @Override
    public Post findOne(long id)
    {
        return postRepository.findOne(id);
    }

    @Override
    public List<Post> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

}
