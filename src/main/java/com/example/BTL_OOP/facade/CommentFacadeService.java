package com.example.BTL_OOP.facade;

import com.example.BTL_OOP.dto.request.comment.CommentRequest;

public interface CommentFacadeService {
  void createComment(CommentRequest commentRequest);

}
