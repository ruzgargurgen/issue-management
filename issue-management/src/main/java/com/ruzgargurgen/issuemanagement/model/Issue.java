package com.ruzgargurgen.issuemanagement.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ruzgargurgen.issuemanagement.enums.IssueStatus;

@Entity
@Table(name="issue")
public class Issue extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="Description",length = 400)
	private String description;
	
	@Column(name="Details",length = 4000)
	private String details;
	
	@Column(name="Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name="ISSUE_STATUS")
	@Enumerated(EnumType.STRING)
	private IssueStatus issueStatus;
	
	@JoinColumn(name = "assignee_user_id")
	@ManyToOne(optional = true,fetch = FetchType.LAZY)
	private User assignee;
	
	@JoinColumn(name = "project_id")
	@ManyToOne(optional = true,fetch = FetchType.LAZY)
	private Project project;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public IssueStatus getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Issue(java.sql.Date createdAt, String createdByString, java.sql.Date updatedAtDate, String updatedByString,
			Boolean status, Long id, String description, String details, Date date, IssueStatus issueStatus,
			User assignee, Project project) {
		super(createdAt, createdByString, updatedAtDate, updatedByString, status);
		this.id = id;
		this.description = description;
		this.details = details;
		this.date = date;
		this.issueStatus = issueStatus;
		this.assignee = assignee;
		this.project = project;
	}

	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Issue(java.sql.Date createdAt, String createdByString, java.sql.Date updatedAtDate, String updatedByString,
			Boolean status) {
		super(createdAt, createdByString, updatedAtDate, updatedByString, status);
		// TODO Auto-generated constructor stub
	}
	
	
}
