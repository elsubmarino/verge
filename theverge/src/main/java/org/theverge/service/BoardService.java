package org.theverge.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.theverge.dto.BoardDTO;
import org.theverge.util.Criteria;

public interface BoardService {
	public List<BoardDTO> getList(Criteria cri);

	public int getTotalCount(Criteria cri);

	public BoardDTO getOne(int num);

	public void insert(BoardDTO dto);

	public void delete(BoardDTO dto);

	public void deleteFromRest(int num);
}
