package com.example.demo.services;

import com.example.demo.DTO.UserDTO;
import com.example.demo.domain.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exception.ObjectNotFooundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = userRepository.findById(id);
        return  obj.orElseThrow(() -> new ObjectNotFooundException("Objeto nao encontrado"));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    //fere um pouco o principio de reponsabilidade,
    //mas colocamos para que possamos futuramente acessar,
    //o banco de dados com a instancia userRepository

    public  User fromDTO(UserDTO userDTO){
        return  new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
    }


}
