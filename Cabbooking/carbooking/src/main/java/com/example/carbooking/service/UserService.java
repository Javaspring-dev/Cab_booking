package com.example.carbooking.service;

import com.example.carbooking.Exception_Handler.ConflictException;
import com.example.carbooking.entities.UserEntity;
import com.example.carbooking.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    public final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity userEntity){
        Optional<UserEntity> customerid = userRepository.findByCustomerid(userEntity.getCustomerid());
        if (customerid.isPresent()){
            throw new ConflictException("User details saved already");
        }
        return userRepository.save(userEntity);

    }

    public Object getById(int id){
        Optional<UserEntity> FindById = userRepository.findByCustomerid(id);
        if (FindById.isPresent()){
            return userRepository.findByCustomerid(id);
        }
        throw new ConflictException("Add the User details");
    }
    }


