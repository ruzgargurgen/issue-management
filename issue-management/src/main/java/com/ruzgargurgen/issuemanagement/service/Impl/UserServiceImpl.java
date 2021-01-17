package com.ruzgargurgen.issuemanagement.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ruzgargurgen.issuemanagement.model.Issue;
import com.ruzgargurgen.issuemanagement.model.User;
import com.ruzgargurgen.issuemanagement.repository.IssueRepository;
import com.ruzgargurgen.issuemanagement.repository.UserRepository;
import com.ruzgargurgen.issuemanagement.service.IssueService;
import com.ruzgargurgen.issuemanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@Override
	public User save(User user) {
		if (user.getEmail()==null) {
			throw new IllegalArgumentException("Username cannot be null");
		}
		return userRepository.save(user);
	}

	@Override
	public User getById(Long id) {
		
		return userRepository.getOne(id);
	}

	@Override
	public Page<User> getAllPageable(Pageable pageable) {
	
		return userRepository.findAll(pageable);
	}
	@Override
	public Boolean delete(User user) {
		userRepository.delete(user);
		return Boolean.TRUE;
	}
	@Override
	public User getByUserName(String userName) {
		return userRepository.getByUserName(userName);
	}

	
}
