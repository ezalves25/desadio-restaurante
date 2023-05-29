package br.com.desafio.msdesafio.controller;

import br.com.desafio.msdesafio.controller.request.UserRequest;
import br.com.desafio.msdesafio.mappers.UserRequestToUserMapper;
import br.com.desafio.msdesafio.model.UserModel;
import br.com.desafio.msdesafio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserRequestToUserMapper mapper;

    @Autowired
    public UserController(UserService userService, UserRequestToUserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> createUser(@RequestBody UserRequest request) {
        UserModel createdUser = userService.createUser(mapper.convert(request));
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody UserModel user) {
        userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserModel> getUser(@PathVariable Long userId) {
        UserModel user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}