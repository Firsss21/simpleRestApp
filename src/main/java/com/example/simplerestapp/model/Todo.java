package com.example.simplerestapp.model;

import com.example.simplerestapp.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public static Todo toModel(TodoEntity todoEntity) {
        Todo todo = new Todo();
        todo.setTitle(todoEntity.getTitle());
        todo.setCompleted(todoEntity.getComplete());
        todo.setId(todoEntity.getId());
        return todo;
    }
}
