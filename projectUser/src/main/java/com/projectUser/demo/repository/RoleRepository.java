package com.projectUser.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectUser.demo.emtity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	public Role findByName(String name);
	
}
