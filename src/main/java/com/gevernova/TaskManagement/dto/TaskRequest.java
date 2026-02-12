package com.gevernova.TaskManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    private String title;
    private String description;
    private Integer userId;
    private Long categoryId;
    private Long priorityId;
}

