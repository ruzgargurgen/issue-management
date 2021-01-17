package com.ruzgargurgen.issuemanagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ruzgargurgen.issuemanagement.model.Project;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	List<Project> findByProjectCode(String projectCode);
	
	List<Project> findByProjectCodeContains(String projectCode);


}
