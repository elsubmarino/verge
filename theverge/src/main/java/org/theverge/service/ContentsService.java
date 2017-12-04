package org.theverge.service;

import java.util.List;

import org.theverge.dto.ContentsDTO;

public interface ContentsService {
	public List<ContentsDTO> getTopics();
	public ContentsDTO getContents(int num);
}
