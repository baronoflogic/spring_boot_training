package com.sumantra.springboot.repository;


import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

import com.sumantra.springboot.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
