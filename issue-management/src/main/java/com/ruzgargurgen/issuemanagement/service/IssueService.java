package com.ruzgargurgen.issuemanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ruzgargurgen.issuemanagement.dto.IssueDto;
import com.ruzgargurgen.issuemanagement.model.Issue;
import com.ruzgargurgen.issuemanagement.util.TPage;

public interface IssueService {
	
	IssueDto save(IssueDto issue);
	IssueDto getById(Long id);
	TPage<IssueDto> getAllPageable(Pageable pageable);
	Boolean delete(IssueDto issue);

}
