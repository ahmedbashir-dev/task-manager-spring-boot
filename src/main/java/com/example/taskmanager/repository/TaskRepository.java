package com.example.taskmanager.repository;

import com.example.taskmanager.enums.TaskStatus;
import com.example.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>{

    // Method to find tasks by their status
    List<Task> findByStatus(TaskStatus status);
}
