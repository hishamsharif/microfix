package com.microfix.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microfix.data.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
