package org.theverge.dao;

import java.util.List;

import org.theverge.dto.SurveyDTO;

public interface SurveyDAO {
	public int insert(SurveyDTO dto);
	public List<SurveyDTO> getList();
}
