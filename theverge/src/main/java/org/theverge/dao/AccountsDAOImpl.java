package org.theverge.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.theverge.dto.AccountsDTO;

@Repository
public class AccountsDAOImpl implements AccountsDAO {
	@Inject
	SqlSession sqlSession;
	private final String namespace = "org.theverge.mapper.accountsMapper";

	@Override
	public int getResult(String id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		return sqlSession.selectOne(namespace + ".getResult", map);
	}

	@Override
	public void insert(AccountsDTO dto) {
		sqlSession.insert(namespace + ".insert", dto);

	}

	@Override
	public long randkey(String id) {
		return sqlSession.selectOne(namespace + ".getRandkey", id);
	}

	@Override
	public void updateRandkey(String id) {
		sqlSession.update(namespace + ".updateRandkey", id);
	}

}
