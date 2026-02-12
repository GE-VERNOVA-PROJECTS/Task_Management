package com.gevernova.TaskManagement.service;
import com.gevernova.TaskManagement.dto.TaskRequest;
import com.gevernova.TaskManagement.exceptions.TaskNotFoundException;
import com.gevernova.TaskManagement.exceptions.UserNotFoundException;
import com.gevernova.TaskManagement.model.*;
import com.gevernova.TaskManagement.repository.CategoryRepository;
import com.gevernova.TaskManagement.repository.PriorityRepository;
import com.gevernova.TaskManagement.repository.TaskRepository
import com.gevernova.TaskManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PriorityRepository priorityRepository;

    public Task create(TaskRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Category category = categoryRepository.findById(Math.toIntExact(request.getCategoryId()))
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Priority priority = priorityRepository.findById(Math.toIntExact(request.getPriorityId()))
                .orElseThrow(() -> new RuntimeException("Priority not found"));

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(TaskStatus.PENDING);
        task.setUser(user);
        task.setCategory(category);
        task.setPriority(priority);

        return taskRepository.save(task);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Integer id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
    }

    public Task updateStatus(Integer id, TaskStatus status) {
        Task task = getById(id);
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }
}

