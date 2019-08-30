package com.h2test.service;
import com.h2test.dto.PostDto;
import com.h2test.domain.Author;
import com.h2test.domain.Post;
import com.h2test.repository.AuthorRepository;
import com.h2test.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private Post post;
    private PostRepository postRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public PostServiceImpl(Post post, PostRepository postRepository, AuthorRepository authorRepository) {
        this.post = post;
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Post> read() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> addItem(PostDto postDto)
    {
        post.setTitle(postDto.getTitle());
        post.setBody(postDto.getBody());

        long authorId=postDto.getAuthorId();
        Author author=authorRepository.findAuthorById(authorId);
        post.setAuthor(author);
        postRepository.save(post);
        return postRepository.findAll();
    }

    @Override
    public void delete(long id)
    {
        postRepository.delete(id);
    }


    @Override
    public Post update(long id,Post postOb)
    {
        post=postRepository.findOne(id);
        if(postOb.getTitle()!=null)
        {
            post.setTitle(postOb.getTitle());
        }
        return postRepository.save(post);
    }

    @Override
    public Post findOne(long id)
    {
        return postRepository.findOne(id);
    }


    public List<Post> findByTitleContaining(String title)
    {
        return postRepository.findByTitleContaining(title);
    }


}
