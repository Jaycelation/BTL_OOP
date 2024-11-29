package com.example.BTL_OOP.entity;

import com.example.BTL_OOP.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
@AllArgsConstructor
public class Comment extends AuditEntity {
  private String content;
  private String taskId;
}
