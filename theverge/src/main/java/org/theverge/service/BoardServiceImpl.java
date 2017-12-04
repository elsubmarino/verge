package org.theverge.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.theverge.dao.BoardDAO;
import org.theverge.dao.CommentsDAO;
import org.theverge.dto.BoardDTO;
import org.theverge.util.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO boardDAO;

	@Inject
	CommentsDAO commentsDAO;

	@Override
	public List<BoardDTO> getList(Criteria cri) {
		return boardDAO.getList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDAO.totalCount(cri);
	}

	@Transactional
	@Override
	public BoardDTO getOne(int num) {
		boardDAO.udpateCnt(num);
		return boardDAO.getOne(num);
	}

	@Transactional
	@Override
	public void insert(BoardDTO dto) {
		System.out.println(dto.getGroupNum() + " getGroupNum from BoardServiceImpl");
		boardDAO.updateForSequence(dto);
		boardDAO.insert(dto);
		if (dto.getGroupNum() == 0)
			boardDAO.updateForGroupNum(dto);

	}

	@Transactional	
	@Override
	public void delete(BoardDTO dto){
	
		boardDAO.delete(dto);
		boardDAO.deleteFromGroupNum(dto.getNum());
		System.out.println("I'm through!");
		commentsDAO.deleteUsingBoardNum(dto.getNum());

	}

	@Override
	public void deleteFromRest(int num) {
		boardDAO.deleteFromRest(num);

	}

}
