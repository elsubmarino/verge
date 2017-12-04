package org.theverge.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.theverge.dao.ContentsDAO;
import org.theverge.dto.ContentsDTO;

@Service
public class ContentsServiceImpl implements ContentsService{
	@Inject
	ContentsDAO contentsDAO;

	@Override
	public List<ContentsDTO> getTopics() {
		return contentsDAO.getTopics();
	}

	@Override
	public ContentsDTO getContents(int num) {
		return contentsDAO.getArticle(num);
	}

}
