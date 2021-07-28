package com.example.simplerestapp.repository;

import com.example.simplerestapp.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}
