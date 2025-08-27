package com.he187184.mvc.rent.repository;

import com.he187184.mvc.rent.common.Role;
import com.he187184.mvc.rent.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    List<User> findByRoleIsNot(Role role);

    boolean existsUserByEmail(String email);

}
