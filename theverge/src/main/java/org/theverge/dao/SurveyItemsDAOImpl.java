package org.theverge.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.theverge.dto.SurveyItemsDTO;

@Repository
public class SurveyItemsDAOImpl implements SurveyItemsDAO {

	private static final String namespace = "org.theverge.mapper.surveyItemsMapper";

	@Inject
	SqlSession sqlSession;

	@Override
	public int insert(SurveyItemsDTO dto) {
		return sqlSession.insert(namespace + ".insert", dto);
	}

	@Override
	public List<SurveyItemsDTO> getList(int num) {
		return sqlSession.selectList(namespace + ".getList", num);
	}

	@Override
	public int getMaxCountFromItems(int num) {
		return sqlSession.selectOne(namespace + ".getMaxCountFromItems", num);
	}

	@Override
	public int updateForItem(SurveyItemsDTO dto) {
		return sqlSession.update(namespace + ".updateForItem", dto);
	}

}
