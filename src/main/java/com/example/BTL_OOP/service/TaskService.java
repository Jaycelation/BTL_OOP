package com.example.BTL_OOP.service;

import com.example.BTL_OOP.dto.request.task.TaskRequest;
import com.example.BTL_OOP.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {
  void create(TaskRequest request);

  void update(String id, TaskRequest request);

  TaskResponse get(String id);

  List<TaskResponse> list(String keyword);

  void delete(String id);

}
