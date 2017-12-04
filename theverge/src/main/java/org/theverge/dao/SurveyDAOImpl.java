package org.theverge.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.theverge.dto.SurveyDTO;

@Repository
public class SurveyDAOImpl implements SurveyDAO {

	private static final String namespace = "org.theverge.mapper.surveyMapper";

	@Inject
	SqlSession sqlSession;

	@Override
	public int insert(SurveyDTO dto) {
		return sqlSession.insert(namespace + ".insert", dto);
	}

	@Override
	public List<SurveyDTO> getList() {
		return sqlSession.selectList(namespace + ".getList");
	}

}
