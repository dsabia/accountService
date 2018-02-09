package com.ing.technicaltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.technicaltest.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
