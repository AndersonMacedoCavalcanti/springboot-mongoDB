package com.example.demo.services;

import com.example.demo.domain.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exception.ObjectNotFooundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
