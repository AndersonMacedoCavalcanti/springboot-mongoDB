package com.example.demo.services;

import com.example.demo.domain.entities.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.services.exception.ObjectNotFooundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFooundException("Objeto nao encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainsIgnoreCase(text);
    }
}