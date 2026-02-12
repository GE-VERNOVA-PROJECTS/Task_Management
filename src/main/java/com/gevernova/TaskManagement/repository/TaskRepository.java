package com.gevernova.TaskManagement.repository;

import com.gevernova.TaskManagement.model.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);

    List<Task> findAll();
}
