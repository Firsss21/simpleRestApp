package com.example.simplerestapp.service;

import com.example.simplerestapp.entity.UserEntity;
import com.example.simplerestapp.exception.UserAlreadyExist;
import com.example.simplerestapp.exception.UserNotExist;
import com.example.simplerestapp.model.User;
import com.example.simplerestapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExist {
        if (userRepo.findByUsername(user.getUsername()) != null)
            throw new UserAlreadyExist("Пользователь с таким именем существует");
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotExist {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotExist("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
