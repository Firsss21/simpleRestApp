package com.example.simplerestapp.controller;

import com.example.simplerestapp.entity.UserEntity;
import com.example.simplerestapp.exception.UserAlreadyExist;
import com.example.simplerestapp.exception.UserNotExist;
import com.example.simplerestapp.repository.UserRepo;
import com.example.simplerestapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
        @Autowired
        private UserService userService;

        @GetMapping
        public ResponseEntity getOneUser(@RequestParam Long id) {
            try {
                return ResponseEntity.ok(userService.getOne(id));
            } catch (UserNotExist e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Произошла ошибка");
            }
        }

        @PostMapping
        public ResponseEntity registration(@RequestBody UserEntity user) {
            try {
                userService.registration(user);
                return ResponseEntity.ok("Пользователь успешно сохранен");
            } catch (UserAlreadyExist e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Произошла ошибка");
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity deleteUser(@PathVariable Long id) {
            try {
                userService.delete(id);
                return ResponseEntity.ok(id);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Произошла ошибка");
            }
        }
}
