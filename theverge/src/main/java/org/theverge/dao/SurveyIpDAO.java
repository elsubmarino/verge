package org.theverge.dao;

import org.theverge.dto.SurveyIpDTO;

public interface SurveyIpDAO {
	public int insert(SurveyIpDTO dto);

	public int check(SurveyIpDTO dto);
}
