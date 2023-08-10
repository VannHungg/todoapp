package com.wazooinc.springboottodoapplication.repository;

import com.wazooinc.springboottodoapplication.model.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
}
