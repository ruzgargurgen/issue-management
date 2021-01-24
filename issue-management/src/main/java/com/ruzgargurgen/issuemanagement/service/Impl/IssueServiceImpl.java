package com.ruzgargurgen.issuemanagement.service.Impl;

import java.util.Arrays;

import javax.xml.crypto.dsig.keyinfo.X509IssuerSerial;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ruzgargurgen.issuemanagement.dto.IssueDto;
import com.ruzgargurgen.issuemanagement.model.Issue;
import com.ruzgargurgen.issuemanagement.repository.IssueRepository;
import com.ruzgargurgen.issuemanagement.service.IssueService;
import com.ruzgargurgen.issuemanagement.util.TPage;
import com.sun.el.stream.Optional;

@Service
public class IssueServiceImpl implements IssueService {

	private final IssueRepository issueRepository;
	private final ModelMapper modelMapper;
	
	 public IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper) {
		this.issueRepository=issueRepository;
		this.modelMapper=modelMapper;
	
	}

	@Override
	public IssueDto create(IssueDto issue) {
		if (issue.getDate()==null) {
			throw new IllegalArgumentException("Issue Date cannot null!");
		}
		Issue issueEntity=modelMapper.map(issue, Issue.class);
		issueEntity=issueRepository.save(issueEntity);
		issue.setId(issueEntity.getId());
		return issue;
	}

	@Override
	public IssueDto getById(Long id) {
		Issue issue=issueRepository.getOne(id);
		return modelMapper.map(issue, IssueDto.class);
	}

	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		Page<Issue> data=issueRepository.findAll(pageable);
		TPage page=new TPage<IssueDto>();
		IssueDto dtos=modelMapper.map(data.getContent(),IssueDto.class);
		page.setStat(data, Arrays.asList(dtos));
		return  page;
	}

	@Override
	public Boolean delete(IssueDto issue) {

		issueRepository.deleteById(issue.getId());
		return Boolean.TRUE;
		
	}

	
	@Override
	public IssueDto update(Long id,IssueDto issue) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
