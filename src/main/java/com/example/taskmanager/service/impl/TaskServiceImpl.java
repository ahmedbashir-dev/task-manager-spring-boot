package com.example.taskmanager.service.impl;

import com.example.taskmanager.enums.TaskStatus;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task) {

//        if(task.getStatus() == null){
//            task.setStatus(TaskStatus.PENDING);
//        }
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(UUID id){
        return taskRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Task not found with id: " + id)
        );
    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public void deleteTaskById(UUID id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTaskByStatus(TaskStatus status){
        return  taskRepository.findByStatus(status);
    }


}
