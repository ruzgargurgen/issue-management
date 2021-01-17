package com.ruzgargurgen.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruzgargurgen.issuemanagement.model.IssueHistory;


public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {

}
