package org.theverge.dao;

import java.util.List;

import org.theverge.dto.SurveyItemsDTO;

public interface SurveyItemsDAO {
	public int insert(SurveyItemsDTO dto);

	public List<SurveyItemsDTO> getList(int num);

	public int getMaxCountFromItems(int num);
	
	public int updateForItem(SurveyItemsDTO dto);
}
