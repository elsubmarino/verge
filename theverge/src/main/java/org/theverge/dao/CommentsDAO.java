package org.theverge.dao;

import java.util.List;

import org.theverge.dto.CommentsDTO;

public interface CommentsDAO {
	public List<CommentsDTO> getComments(CommentsDTO dto);
	public int insert(CommentsDTO dto);
	public void updateForSequence(CommentsDTO dto);
	public void updateForGroupNum(int num);
	public void deleteUsingBoardNum(int num);
}
