package com.ruzgargurgen.issuemanagement.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ruzgargurgen.issuemanagement.dto.ProjectDto;
import com.ruzgargurgen.issuemanagement.model.Project;
import com.ruzgargurgen.issuemanagement.repository.ProjectRepository;
import com.ruzgargurgen.issuemanagement.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProjectDto save(ProjectDto project) {

		Project projectCheck = projectRepository.findByProjectCode(project.getProjectCode());
		if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exist");
		Project p = modelMapper.map(project, Project.class);
		p = projectRepository.save(p);
		project.setId(p.getId());
		return project;
	}

	@Override
	public ProjectDto getById(Long id) {
		Project project = projectRepository.getOne(id);
		return modelMapper.map(project, ProjectDto.class);
	}

	@Override
	public ProjectDto getByProjectCode(String projectCode) {
		return null;
	}

	@Override
	public List<Project> getByProjectCodeContains(String projectCode) {
		return null;
	}

	@Override
	public Page<Project> getAllPageable(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(Long id) {
		projectRepository.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public ProjectDto update(Long id, ProjectDto project) {

		Project projectDb = projectRepository.getOne(id);
		if (projectDb == null) {
			throw new IllegalArgumentException("Project Code Does Not Exist!" + id);
		}

		Project projectCheck = projectRepository.findByProjectCodeAndIdNot(project.getProjectCode(), id);
		if (projectCheck == null) {
			throw new IllegalArgumentException("Project Code Already Exist");
		}

		projectDb.setProjectCode(project.getProjectCode());
		projectDb.setProjectName(project.getProjectName());
		projectRepository.save(projectDb);
		return modelMapper.map(projectDb, ProjectDto.class);

	}

}
