package org.theverge.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.theverge.dto.BoardDTO;
import org.theverge.util.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	SqlSession sqlSession;
	private final String namespace = "org.theverge.mapper.boardMapper";

	@Override
	public List<BoardDTO> getList(Criteria cri) {
		System.out.println(cri.getSearchType() + " _Debug:searchType from BoardDAOImpl getList");
		return sqlSession.selectList(namespace + ".getList", cri);
	}

	@Override
	public int totalCount(Criteria cri) {
		System.out.println(cri.getKeyword() + " _Debug:searchType from BoardDAOImpl");
		System.out.println(cri.getSearchType() + " _Debug:searchType from BoardDAOImpl");
		
		if(cri.getKeyword()!=null && !cri.getKeyword().equals("")){
			System.out.println(cri.getKeyword().length());
		System.out.println(cri.getKeyword().equals(""));
		
		}
		return sqlSession.selectOne(namespace + ".getTotalCount", cri);
	}

	@Override
	public BoardDTO getOne(int num) {
		return sqlSession.selectOne(namespace + ".getOne", num);
	}

	@Override
	public void insert(BoardDTO dto) {
		sqlSession.insert(namespace + ".insert", dto);

	}

	@Override
	public void updateForSequence(BoardDTO dto) {
		sqlSession.update(namespace + ".updateForSequence", dto);

	}

	@Override
	public void udpateCnt(int num) {
		sqlSession.update(namespace + ".updateCnt", num);

	}

	@Override
	public void delete(BoardDTO dto) {
		sqlSession.delete(namespace + ".delete", dto);

	}

	@Override
	public void updateForGroupNum(BoardDTO dto) {
		sqlSession.update(namespace + ".updateForGroupNum", dto);

	}

	@Override
	public void deleteFromGroupNum(int num) {
		sqlSession.delete(namespace + ".deleteFromGroupNum", num);
	}

	@Override
	public void deleteFromRest(int num) {
		sqlSession.delete(namespace + ".deleteFromRest", num);

	}

}
