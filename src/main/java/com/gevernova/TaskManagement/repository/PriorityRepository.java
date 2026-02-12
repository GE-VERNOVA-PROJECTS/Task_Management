package com.gevernova.TaskManagement.repository;

import com.gevernova.TaskManagement.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority, Integer> {
}
