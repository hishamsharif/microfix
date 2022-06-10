package com.awraaq.ems.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awraaq.ems.data.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
