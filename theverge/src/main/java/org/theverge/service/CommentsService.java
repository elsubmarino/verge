package org.theverge.service;

import java.util.List;

import org.theverge.dto.CommentsDTO;

public interface CommentsService {
	public List<CommentsDTO> getComments(CommentsDTO dto);
	public void insert(CommentsDTO num);
}
