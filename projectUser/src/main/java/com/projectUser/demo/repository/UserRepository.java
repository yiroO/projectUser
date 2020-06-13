package com.projectUser.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectUser.demo.emtity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> findByUserName(String username);
}
