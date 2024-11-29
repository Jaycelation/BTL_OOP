package com.example.BTL_OOP.service.impl;

import com.example.BTL_OOP.dto.request.comment.CommentRequest;
import com.example.BTL_OOP.dto.response.CommentResponse;
import com.example.BTL_OOP.entity.Comment;
import com.example.BTL_OOP.exception.comment.CommentNotFoundException;
import com.example.BTL_OOP.repositiory.CommentRepository;
import com.example.BTL_OOP.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
  private final CommentRepository repository;

  @Override
  public void create(CommentRequest request) {
    Comment comment = new Comment(
          request.getContent(),
          request.getTaskId()
    );
    repository.save(comment);
  }


  @Override
  public List<CommentResponse> findByTaskId(String taskId) {
    return repository.getCommentByTaskId(taskId);
  }

  private Comment find(String id) {
    return repository.findById(id).orElseThrow(CommentNotFoundException::new);
  }
}
