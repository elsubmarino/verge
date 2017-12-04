package org.theverge.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.theverge.dao.CommentsDAO;
import org.theverge.dto.CommentsDTO;

@Service
public class CommentsServiceImpl implements CommentsService {
	@Inject
	CommentsDAO commentsDAO;

	@Override
	public List<CommentsDTO> getComments(CommentsDTO dto) {
		return commentsDAO.getComments(dto);
	}

	@Transactional
	@Override
	public void insert(CommentsDTO dto) {
		commentsDAO.updateForSequence(dto);
		commentsDAO.insert(dto);
		if (dto.getGroupNum() == 0)
			commentsDAO.updateForGroupNum(dto.getNum());

	}

}
