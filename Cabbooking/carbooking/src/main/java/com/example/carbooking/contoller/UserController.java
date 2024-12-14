package com.example.carbooking.contoller;

import com.example.carbooking.entities.RegisterEntity;
import com.example.carbooking.entities.UserEntity;
import com.example.carbooking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    public final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity>createUser(@RequestBody UserEntity userEntity)
    {
        UserEntity SavedEntity=userService.create(userEntity);
        return ResponseEntity.ok(SavedEntity);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        return ResponseEntity.ok().body(userService.getById(id));
    }


}
