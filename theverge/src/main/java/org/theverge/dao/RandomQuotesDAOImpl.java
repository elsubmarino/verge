package org.theverge.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.theverge.dto.RandomQuotesDTO;

@Repository
public class RandomQuotesDAOImpl implements RandomQuotesDAO{
	@Inject
	private SqlSession sqlSession;
	
	private final String namespace="org.theverge.mapper.randomQuotes";
	

	@Override
	public RandomQuotesDTO getQuotes() {
		return sqlSession.selectOne(namespace+".getQuotes");
	}
	
	
}
