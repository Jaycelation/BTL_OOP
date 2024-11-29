package com.example.BTL_OOP.service;

import com.example.BTL_OOP.dto.request.comment.CommentRequest;
import com.example.BTL_OOP.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {
  void create(CommentRequest request);

  List<CommentResponse> findByTaskId(String taskId);
}
