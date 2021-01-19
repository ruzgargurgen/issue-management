package com.ruzgargurgen.issuemanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectServiceImpl projectServiceImpl;

	@GetMapping("/{id}")
	public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id",required = true) Long id) {
		ProjectDto projectDto=projectServiceImpl.getById(id);
		return ResponseEntity.ok(projectDto);
	}
     
	@PostMapping()
	public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto project){
		return ResponseEntity.ok(projectServiceImpl.save(project));
	}
	
	@PutMapping("/{id}")
	public  ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id",required = true) Long id,@RequestBody ProjectDto project){
		return ResponseEntity.ok(projectServiceImpl.update(id, project));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id",required = true) Long id) {
		return ResponseEntity.ok(projectServiceImpl.delete(id));
	}

}
