package org.theverge.dao;

import java.util.List;

import org.theverge.dto.BoardDTO;
import org.theverge.util.Criteria;

public interface BoardDAO {
	public List<BoardDTO> getList(Criteria cri);

	public BoardDTO getOne(int num);

	public int totalCount(Criteria cri);

	public void insert(BoardDTO dto);

	public void updateForSequence(BoardDTO dto);

	public void udpateCnt(int num);

	public void updateForGroupNum(BoardDTO dto);

	public void delete(BoardDTO dto);
	
	public void deleteFromGroupNum(int num);
	
	public void deleteFromRest(int num);

}
