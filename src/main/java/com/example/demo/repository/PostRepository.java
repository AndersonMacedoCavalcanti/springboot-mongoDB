package com.example.demo.repository;

import com.example.demo.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    //Pode usar varios comando so usando o find..... que o spring gera querie automaticamente
    //https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#reference
    //IgnoreCase para ignorar letras maiusculas e minusculas
    List<Post> findByTitleContainsIgnoreCase(String text);


    //-------------------------------------------------------------------


    //outra forma usando @Query
    //https://docs.mongodb.com/manual/reference/operator/query/regex/
    //   nome do campo, ?0 = o primeiro parametro que vem no metodo, i = opcao para ignorar maius e minus...
    @Query("{ 'title': { $regex: ?0, $options: i } }")
    List<Post> searchTitle(String text);
                                                                                                                                                               //para buscar o text dentro do comentario
    @Query("{ $and: [ {date: {$gte: ?1} }, { date: { $lte: ?2}}, { $or: [ { 'title': { $regex: ?0, $options: i } }, { 'body': { $regex: ?0, $options: i } }, { 'commentDTOList.text': { $regex: ?0, $options: i } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);


}
