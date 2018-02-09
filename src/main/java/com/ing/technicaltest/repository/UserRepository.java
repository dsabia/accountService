package com.ing.technicaltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.technicaltest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}
