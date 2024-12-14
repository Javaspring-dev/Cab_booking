package com.example.carbooking.service;

import com.example.carbooking.Exception_Handler.ConflictException;
import com.example.carbooking.dto.LoginDto;
import com.example.carbooking.entities.RegisterEntity;
import com.example.carbooking.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    public  RegisterEntity create(RegisterEntity registerEntity){
        Optional<RegisterEntity> username = registerRepository.findByUsername(registerEntity.getUsername());
        if (username.isPresent()){
             throw new ConflictException("User Already Exists");
        }
        return registerRepository.save(registerEntity);
    }
    public String login(LoginDto loginDto) {
        Optional<RegisterEntity> registerEntity = registerRepository.findByUsername(loginDto.getUsername());
        if (registerEntity.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        if (!registerEntity.get().getPassword().equals(loginDto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return registerEntity.get().getUsertype();
    }

}
