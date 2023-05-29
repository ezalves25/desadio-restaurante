package br.com.desafio.msdesafio.service;

import br.com.desafio.msdesafio.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel createUser(UserModel user);

    void updateUser(UserModel user);

    void deleteUser(Long userId);

    UserModel getUser(Long userId);

    List<UserModel> getAllUsers();
}