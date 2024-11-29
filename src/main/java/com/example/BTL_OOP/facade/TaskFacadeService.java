package com.example.BTL_OOP.facade;

import com.example.BTL_OOP.dto.request.task.TaskRequest;
import com.example.BTL_OOP.dto.response.TaskResponse;

public interface TaskFacadeService {
  void createTask(TaskRequest request);

  void updateTask(String id,TaskRequest request);

  TaskResponse detail(String id);
}
