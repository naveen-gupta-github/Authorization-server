package com.naveen.security.autharizationserver.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naveen.security.autharizationserver.models.Users;

@Repository
public interface UserDetailRepo extends JpaRepository<Users, Integer> {

	Optional<Users> findByUsername(String name);
	
}
