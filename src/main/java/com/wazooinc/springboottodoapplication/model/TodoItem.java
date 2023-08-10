package com.wazooinc.springboottodoapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "todo_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Description is required")
    private String description;
    private boolean complete;
    private Instant createdDate;
    private Instant modifiedDate;

    public TodoItem(String description) {
        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }

    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, description='%s', complete='%s', createdDate='%s', modifiedDate='%s'}",
                id, description, complete, createdDate, modifiedDate);
    }
}
