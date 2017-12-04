package org.theverge.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.theverge.dao.SurveyIpDAO;
import org.theverge.dto.SurveyIpDTO;

@Service
public class ServeyIPSeviceImpl implements SurveyIPService {

	@Inject
	SurveyIpDAO surveyIpsDAO;

	@Override
	public int insert(SurveyIpDTO dto) {
		return surveyIpsDAO.insert(dto);
	}

	@Override
	public int check(SurveyIpDTO dto) {
		return surveyIpsDAO.check(dto);
	}

}
