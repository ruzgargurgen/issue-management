package com.ruzgargurgen.issuemanagement.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruzgargurgen.issuemanagement.dto.ProjectDto;
import com.ruzgargurgen.issuemanagement.service.Impl.ProjectServiceImpl;
import com.ruzgargurgen.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = "Project APIs")
public class ProjectController {
	
	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
	public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id",required = true) Long id) {
		ProjectDto projectDto=projectServiceImpl.getById(id);
		return ResponseEntity.ok(projectDto);
	}
     
	@PostMapping()
	@ApiOperation(value = "Create Operation",response = ProjectDto.class)
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){
		return ResponseEntity.ok(projectServiceImpl.save(project));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Update Operation",response = ProjectDto.class)
	public  ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id",required = true) Long id,@RequestBody ProjectDto project){
		return ResponseEntity.ok(projectServiceImpl.update(id, project));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Operation",response = Boolean.class)
	public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id",required = true) Long id) {
		return ResponseEntity.ok(projectServiceImpl.delete(id));
	}

}
