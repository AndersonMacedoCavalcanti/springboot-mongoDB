package com.example.demo.config;

import com.example.demo.DTO.AuthorDTO;
import com.example.demo.DTO.CommentDTO;
import com.example.demo.domain.entities.Post;
import com.example.demo.domain.entities.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Caria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null, sdf.parse("21/01/2021"),"Partiu viagem", "Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
        Post post2 = new Post(null,sdf.parse("23/01/2021"),"Bom dia","Acordei feliz hoje!",new AuthorDTO(maria));

        CommentDTO commentDTO1 = new CommentDTO("Boa viagem mano!",sdf.parse( "21/01/2021"),new AuthorDTO(alex));
        CommentDTO commentDTO2 = new CommentDTO("Aproveite",sdf.parse( "21/01/2021"),new AuthorDTO(bob));
        CommentDTO commentDTO3 = new CommentDTO("Tenha um bom dia",sdf.parse( "23/01/2021"),new AuthorDTO(alex));

        post1.getCommentDTOList().addAll(Arrays.asList(commentDTO1,commentDTO2));
        post2.getCommentDTOList().addAll(Arrays.asList(commentDTO3));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPostList().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);


    }

}
