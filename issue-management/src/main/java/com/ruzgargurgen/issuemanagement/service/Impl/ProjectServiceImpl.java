package com.ruzgargurgen.issuemanagement.service.Impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ruzgargurgen.issuemanagement.model.Issue;
import com.ruzgargurgen.issuemanagement.model.Project;
import com.ruzgargurgen.issuemanagement.repository.IssueRepository;
import com.ruzgargurgen.issuemanagement.repository.ProjectRepository;
import com.ruzgargurgen.issuemanagement.service.IssueService;
import com.ruzgargurgen.issuemanagement.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	
	 public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository=projectRepository;
	}

	@Override
	public Project save(Project project) {
		if (project.getProjectCode()==null) {
			throw new IllegalArgumentException("Project Code Connot be Null!");
		}
		return projectRepository.save(project);
	}

	@Override
	public Project getById(Long id) {
		
		return projectRepository.getOne(id);
	}

	@Override
	public List<Project> getByProjectCode(String projectCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getByProjectCodeContains(String projectCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Project> getAllPageable(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(Project project) {
		projectRepository.delete(project);
		return Boolean.TRUE;
	}

	
	
}
