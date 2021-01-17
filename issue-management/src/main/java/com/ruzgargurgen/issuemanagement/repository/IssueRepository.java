package com.ruzgargurgen.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruzgargurgen.issuemanagement.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
