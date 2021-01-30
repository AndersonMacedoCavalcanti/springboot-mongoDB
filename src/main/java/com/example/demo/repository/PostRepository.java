package com.example.demo.repository;

import com.example.demo.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    //Pode usar varios comando so usando o find..... ele gera a querie automaticamente
    //IgnoreCase para ignorar letras maiusculas e minusculas
    List<Post> findByTitleContainsIgnoreCase(String text);
}
