package com.ruzgargurgen.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ruzgargurgen.issuemanagement.model.Issue;
import com.ruzgargurgen.issuemanagement.model.Project;

public interface ProjectService {
	
	Project save(Project project);
	Project getById(Long id);
	List<Project> getByProjectCode(String projectCode);
	List<Project> getByProjectCodeContains(String projectCode);
	Page<Project> getAllPageable(Pageable pageable);
    Boolean delete(Project project);

}
