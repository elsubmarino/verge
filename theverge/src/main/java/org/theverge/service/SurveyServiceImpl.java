package org.theverge.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.theverge.dao.SurveyDAO;
import org.theverge.dao.SurveyItemsDAO;
import org.theverge.dto.SurveyDTO;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Inject
	SurveyDAO surveyDAO;

	@Override
	public int insert(SurveyDTO dto) {
		return surveyDAO.insert(dto);
	}

	@Override
	public List<SurveyDTO> getList() {
		return surveyDAO.getList();
	}

}
