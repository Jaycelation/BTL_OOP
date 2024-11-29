package com.example.BTL_OOP.repositiory;

import com.example.BTL_OOP.dto.response.CommentResponse;
import com.example.BTL_OOP.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {

  @Query("""
        SELECT new com.example.BTL_OOP.dto.response.CommentResponse(
         c.id, c.content, c.createdAt, u.id, u.email, u.name
        ) FROM Comment c
        LEFT JOIN User u ON c.createdBy = u.email
        WHERE c.taskId = :taskId
        """)
  List<CommentResponse> getCommentByTaskId(String taskId);
}
