package com.wazooinc.springboottodoapplication.config;

import com.wazooinc.springboottodoapplication.model.TodoItem;
import com.wazooinc.springboottodoapplication.repository.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner {
    @Autowired
    TodoItemRepository todoItemRepository;
    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if(todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("do the homework");
            TodoItem todoItem2 = new TodoItem("create repository on github");
            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }
        logger.info("Number of to do list: {}", todoItemRepository.count());
    }
}
