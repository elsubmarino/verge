package org.theverge.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.theverge.dto.ContentsDTO;

@Repository
public class ContentsDAOImpl implements ContentsDAO{
	@Inject
	SqlSession sqlSession;
	private final String namespace="org.theverge.mapper.contentsMapper";
	@Override
	public List<ContentsDTO> getTopics() {
		return sqlSession.selectList(namespace+".getTopics");
	}
	@Override
	public ContentsDTO getArticle(int num) {
		return sqlSession.selectOne(namespace+".getArticle",num);
	}


}
