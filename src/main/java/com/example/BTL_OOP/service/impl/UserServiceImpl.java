package com.example.BTL_OOP.service.impl;

import com.example.BTL_OOP.dto.request.user.UserRequest;
import com.example.BTL_OOP.dto.response.UserResponse;
import com.example.BTL_OOP.entity.User;
import com.example.BTL_OOP.exception.base.NotFoundException;
import com.example.BTL_OOP.exception.user.EmailAlreadyExistException;
import com.example.BTL_OOP.repositiory.UserRepository;
import com.example.BTL_OOP.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.BTL_OOP.utils.PasswordEncoderUtils.PASSWORD_ENCODER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository repository;

  @Override
  public UserResponse create(UserRequest request) {

    this.checkExistByEmail(request.email());
    final User user = toEntity(request);
    final User userSaved = repository.save(user);

    return toResponse(userSaved);
  }

  @Override
  public UserResponse detail(String id) {

    return toResponse(this.find(id));
  }

  @Override
  public User findByUserName(String username) {
    return repository.findByUsername(username).orElseThrow(NotFoundException::new);
  }

  @Override
  public User findById(String id) {
    return repository.findById(id).orElseThrow(NotFoundException::new);
  }

  @Override
  public List<UserResponse> findAll() {
    List<User> users = repository.findAll();

    return users.stream()
          .map(this::toResponse)
          .collect(Collectors.toList());
  }


  private void checkExistByEmail(String email) {
    if(repository.existsByEmail(email)) {
      throw new EmailAlreadyExistException();
    }
  }

  private User toEntity(UserRequest request) {
    return new User(
          request.email(),
          PASSWORD_ENCODER.encode(request.password()),
          request.name()
    );
  }

  private UserResponse toResponse(User user) {
    return new UserResponse(
          user.getId(),
          user.getEmail(),
          user.getName()
    );
  }

  private User find(String id) {
    return repository.findById(id).orElseThrow(NotFoundException::new);
  }
}
