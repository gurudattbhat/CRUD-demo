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
    public Post addItem(PostDto postDto)
    {
        post.setTitle(postDto.getTitle());
        post.setBody(postDto.getBody());
        post.setId(postDto.getId());
        long authorId=postDto.getAuthorId();
        Author author=authorRepository.findAuthorById(authorId);
        post.setAuthor(author);
        return postRepository.save(post);

    }

    @Override
    public void delete(long id)
    {
        postRepository.deleteById(id);
    }


    @Override
    public Post update(long id,Post postOb)
    {
        post=postRepository.getOne(id);
        if(postOb.getTitle()!=null)
        {
            post.setTitle(postOb.getTitle());
        }
        return postRepository.save(post);
    }

    @Override
    public Post getOne(long id)
    {
        return postRepository.findPostById(id);
    }


    public List<Post> findByTitleContaining(String title)
    {
        return postRepository.findByTitleContaining(title);
    }


}
