package org.theverge.dao;

import java.util.List;

import org.theverge.dto.ContentsDTO;

public interface ContentsDAO {
	public List<ContentsDTO> getTopics();
	public ContentsDTO getArticle(int num);
}
