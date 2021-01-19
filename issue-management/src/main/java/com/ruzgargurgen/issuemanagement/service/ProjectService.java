package com.ruzgargurgen.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ruzgargurgen.issuemanagement.dto.ProjectDto;
import com.ruzgargurgen.issuemanagement.model.Issue;
import com.ruzgargurgen.issuemanagement.model.Project;

public interface ProjectService {
	
	ProjectDto save(ProjectDto project);
	ProjectDto getById(Long id);
	ProjectDto getByProjectCode(String projectCode);
	List<Project> getByProjectCodeContains(String projectCode);
	Page<Project> getAllPageable(Pageable pageable);
    Boolean delete(Long id);
    ProjectDto update(Long id,ProjectDto project);

}
