package org.theverge.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.theverge.dto.SurveyDTO;
import org.theverge.dto.SurveyItemsDTO;
import org.theverge.dto.SurveyIpDTO;

@Repository
public class SurveyIpDAOImpl implements SurveyIpDAO {

	private static final String namespace = "org.theverge.mapper.surveyIpMapper";

	@Inject
	SqlSession sqlSession;

	@Override
	public int insert(SurveyIpDTO dto) {
		return sqlSession.insert(namespace + ".insert", dto);
	}

	@Override
	public int check(SurveyIpDTO dto) {
		return sqlSession.selectOne(namespace + ".check", dto);
	}

}
