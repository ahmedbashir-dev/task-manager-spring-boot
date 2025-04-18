package com.example.taskmanager.service;

import com.example.taskmanager.enums.TaskStatus;
import com.example.taskmanager.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task save(Task task);

    List<Task> getAllTasks();

    Task getTaskById(UUID id);

    void deleteTaskById(UUID id);

    List<Task> getTaskByStatus(TaskStatus status);
}
