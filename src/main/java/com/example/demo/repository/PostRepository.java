package com.example.demo.repository;

import com.example.demo.domain.entities.Post;
import com.example.demo.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
