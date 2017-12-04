package org.theverge.service;

import java.util.List;

import org.theverge.dto.SurveyDTO;

public interface SurveyService {
	public int insert(SurveyDTO dto);
	public List<SurveyDTO> getList();
}
