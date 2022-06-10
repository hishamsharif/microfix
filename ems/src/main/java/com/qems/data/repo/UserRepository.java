package com.qems.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qems.data.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
