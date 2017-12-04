package org.theverge.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.theverge.dto.SubCategoryDTO;

@Repository
public class SubCategoryDAOImpl implements SubCategoryDAO{
	@Inject
	SqlSession sqlSession;
	private final String namespace="org.theverge.mapper.subCategoryMapper";
	@Override
	public List<SubCategoryDTO> getNames(int num) {
		return sqlSession.selectList(namespace+".getNames",num);
	}



}
