package org.theverge.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.theverge.dto.CommentsDTO;

@Repository
public class CommentsDAOImpl implements CommentsDAO{
	@Inject
	private SqlSession sqlSession;
	
	private final String namespace="org.theverge.mapper.comments";

	@Override
	public List<CommentsDTO> getComments(CommentsDTO dto) {
		return sqlSession.selectList(namespace+".getComments",dto);
	}

	@Override
	public int insert(CommentsDTO num) {
		return sqlSession.insert(namespace+".insert",num);
		
	}

	@Override
	public void updateForSequence(CommentsDTO dto) {
		sqlSession.update(namespace+".updateForSequence",dto);
		
	}

	@Override
	public void updateForGroupNum(int num) {
		sqlSession.update(namespace+".updateForGroupNum",num);
		
	}

	@Override
	public void deleteUsingBoardNum(int num) {
		sqlSession.delete(namespace+".deleteUsingBoardNum",num);
		
	}
	

	
	
	
}
