package com.example.BTL_OOP.entity;

import com.example.BTL_OOP.entity.base.AuditEntity;
import com.example.BTL_OOP.enums.Priority;
import com.example.BTL_OOP.enums.StatusTask;
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
@Table(name = "tasks")
@AllArgsConstructor
public class Task extends AuditEntity {
  private String title;
  private String description;
  private String date;
  private Priority priority;
  private StatusTask status;
  private String userId;
}
