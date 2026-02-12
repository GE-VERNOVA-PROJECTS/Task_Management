package com.gevernova.TaskManagement.dto;

import com.gevernova.TaskManagement.model.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskStatusRequest {
    private TaskStatus status;
}

