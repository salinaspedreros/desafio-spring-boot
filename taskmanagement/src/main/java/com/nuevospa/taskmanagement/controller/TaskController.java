package com.nuevospa.taskmanagement.controller;

import com.nuevospa.taskmanagement.entity.Task;
import com.nuevospa.taskmanagement.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@Tag(name = "Tasks", description = "Task Management API")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    @Operation(summary = "Get all tasks")
    public List<Task> listAll() {
        return taskService.listAll();
    }

    @PostMapping
    @Operation(summary = "Create a new task")
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a task by ID")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a task by ID")
    public Task getById(@PathVariable Long id) {
        return taskService.getById(id);
    }
}
