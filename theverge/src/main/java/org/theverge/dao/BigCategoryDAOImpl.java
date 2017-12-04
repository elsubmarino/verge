package org.theverge.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.theverge.dto.BigCategoryDTO;

@Repository
public class BigCategoryDAOImpl implements BigCategoryDAO{
	@Inject
	SqlSession sqlSession;
	private final String namespace="org.theverge.mapper.bigCategoryMapper";

	@Override
	public List<BigCategoryDTO> getNames() {
		return sqlSession.selectList(namespace+".getNames");
	}

}
