package com.gevernova.TaskManagement.service;


import com.gevernova.TaskManagement.dto.UserRequest;
import com.gevernova.TaskManagement.exceptions.UserNotFoundException;
import com.gevernova.TaskManagement.model.User;
import com.gevernova.TaskManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(UserRequest request) {
        User user = new User(null, request.getName(), request.getEmail());
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User update(Integer id, UserRequest request) {
        User user = getById(id);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}

