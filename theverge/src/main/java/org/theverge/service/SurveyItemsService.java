package org.theverge.service;

import java.util.List;

import org.theverge.dto.SurveyItemsDTO;

public interface SurveyItemsService {
	public int insert(SurveyItemsDTO dto);

	public List<SurveyItemsDTO> getList(int num);

	public int maxCount(int num);
	
	public int updateForItem(SurveyItemsDTO dto);
}
