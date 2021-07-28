package com.example.simplerestapp.service;

import com.example.simplerestapp.entity.TodoEntity;
import com.example.simplerestapp.entity.UserEntity;
import com.example.simplerestapp.model.Todo;
import com.example.simplerestapp.repository.TodoRepo;
import com.example.simplerestapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity userEntity = userRepo.findById(userId).get();
        todo.setId(userEntity.getId());
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long id){
        TodoEntity todoEntity = todoRepo.findById(id).get();
        todoEntity.setComplete(!todoEntity.getComplete());
        return Todo.toModel(todoRepo.save(todoEntity));
    }

}
