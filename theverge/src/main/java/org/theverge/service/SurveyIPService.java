package org.theverge.service;

import org.theverge.dto.SurveyIpDTO;

public interface SurveyIPService {
	public int insert(SurveyIpDTO dto);

	public int check(SurveyIpDTO dto);
}
