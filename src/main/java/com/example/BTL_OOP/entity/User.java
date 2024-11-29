package com.example.BTL_OOP.entity;

import com.example.BTL_OOP.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User extends AuditEntity {
  private String email;
  private String password;
  private String name;

  public User(String email, String password, String name) {
    this.password = password;
    this.email = email;
    this.name = name;
  }



}
