package com.example.BTL_OOP.facade.impl;

import com.example.BTL_OOP.dto.request.comment.CommentRequest;
import com.example.BTL_OOP.facade.CommentFacadeService;
import com.example.BTL_OOP.service.CommentService;
import com.example.BTL_OOP.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentFacadeServiceImpl implements CommentFacadeService {
  private final CommentService commentService;
  private final TaskService taskService;
  @Override
  public void createComment(CommentRequest commentRequest) {
     taskService.get(commentRequest.getTaskId());
     commentService.create(commentRequest);
  }

}
