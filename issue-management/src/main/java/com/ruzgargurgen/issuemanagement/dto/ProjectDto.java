package com.ruzgargurgen.issuemanagement.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Project Data Transfer Object")
public class ProjectDto {
	
	@ApiModelProperty(value = "Project ID")
	private Long id;
    
	@ApiModelProperty(required = true,value = "Name Of Project")
	@NotNull
	private String projectName;
	
	@ApiModelProperty(required = true,value = "Code Of Project")
	@NotNull
	private String projectCode;
	
	public ProjectDto() {
		
	}
	public ProjectDto(Long id, String projectName, String projectCode) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectCode = projectCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

}
