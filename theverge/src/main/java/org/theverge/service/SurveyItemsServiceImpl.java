package org.theverge.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.theverge.dao.SurveyItemsDAO;
import org.theverge.dto.SurveyItemsDTO;

@Service
public class SurveyItemsServiceImpl implements SurveyItemsService {

	@Inject
	SurveyItemsDAO surveyItemsDAO;

	@Override
	public int insert(SurveyItemsDTO dto) {
		return surveyItemsDAO.insert(dto);
	}

	@Override
	public List<SurveyItemsDTO> getList(int num) {
		return surveyItemsDAO.getList(num);
	}

	@Override
	public int maxCount(int num) {
		return surveyItemsDAO.getMaxCountFromItems(num);
	}

	@Override
	public int updateForItem(SurveyItemsDTO dto) {
		return surveyItemsDAO.updateForItem(dto);
	}

}
