package com.ruzgargurgen.issuemanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ruzgargurgen.issuemanagement.model.Issue;
import com.ruzgargurgen.issuemanagement.model.User;

public interface UserService {
	
	User save(User user);
	User getById(Long id);
	Page<User> getAllPageable(Pageable pageable);
	Boolean delete(User user); 
	User getByUserName(String userName);

}
