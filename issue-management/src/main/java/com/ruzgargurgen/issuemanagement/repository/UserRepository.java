package com.ruzgargurgen.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruzgargurgen.issuemanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User getByUserName(String userName);

}
