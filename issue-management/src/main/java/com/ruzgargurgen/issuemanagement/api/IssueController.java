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

import com.ruzgargurgen.issuemanagement.dto.IssueDto;
import com.ruzgargurgen.issuemanagement.service.Impl.IssueServiceImpl;
import com.ruzgargurgen.issuemanagement.util.ApiPaths;


@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {
	
	@Autowired
	private IssueServiceImpl issueServiceImpl;

	@GetMapping("/{id}")
	public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id) {
		IssueDto issueDto=issueServiceImpl.getById(id);
		return ResponseEntity.ok(issueDto);
	}
     
	@PostMapping()
	public ResponseEntity<IssueDto> createProject(@RequestBody IssueDto issue){
		return ResponseEntity.ok(issueServiceImpl.create(issue));
	}
	
	@PutMapping("/{id}")
	public  ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id",required = true) Long id,@RequestBody IssueDto issue){
		return ResponseEntity.ok(issueServiceImpl.update(id,issue));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id",required = true) IssueDto issue) {
		return ResponseEntity.ok(issueServiceImpl.delete(issue));
	}

}
