package com.wazooinc.springboottodoapplication.controller;

import com.wazooinc.springboottodoapplication.model.TodoItem;
import com.wazooinc.springboottodoapplication.repository.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoFormController {
    private final Logger logger = LoggerFactory.getLogger(TodoFormController.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("create-todo")
    public String showCreateForm(Model model) {
        model.addAttribute("todoItem", new TodoItem());
        return "add-todo-item";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        model.addAttribute("todo", todoItem);
        return "update-todo-item";
    }

    @GetMapping("delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        todoItemRepository.delete(todoItem);
        return "redirect:/";
    }
}
