package com.example.taskmanager.controller;

import com.example.taskmanager.enums.TaskStatus;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id")UUID id){
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTaskByStatus(@PathVariable("status")TaskStatus status){
        List<Task> tasks = taskService.getTaskByStatus(status);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task taskBody){
        Task task = taskService.save(taskBody);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id")UUID id){
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }


}
