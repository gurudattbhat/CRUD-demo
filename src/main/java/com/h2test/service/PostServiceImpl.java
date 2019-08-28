package com.h2test.service;

import javax.transaction.Transactional;
import com.h2test.domain.Post;
import com.h2test.repository.AuthorRepository;
import com.h2test.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Iterable<Post> list() {
        return postRepository.findAll();
    }

    public List<Post> addItem(Post post){
        postRepository.save(post);
        return postRepository.findAll();
    }

//    @Override
//    public Post read(long id) {
//        return postRepository.findOne(id);
//    }
//
//    @Override
//    @Transactional
//    public Post create(Post post) {
//        // save the new author
//        authorRepository.save(post.getAuthor());
//        return postRepository.save(post);
//    }
//
//    @Override
//    public void delete(long id) {
//        postRepository.delete(id);
//    }
//
//    @Override
//    public Post update(long id,Post update) {
//        Post post = postRepository.findOne(id);
//        if( update.getTitle() != null ) {
//            post.setTitle(update.getTitle());
//        }
//        return postRepository.save(post);
//    }
}
