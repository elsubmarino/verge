package org.theverge.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.theverge.dao.AccountsDAO;
import org.theverge.dto.AccountsDTO;
import org.theverge.dto.CommentsDTO;

@Service
public class AccountsServiceImpl implements AccountsService {
	@Inject
	AccountsDAO accountsDAO;

	@Override
	public int getResult(String id, String password) {
		return accountsDAO.getResult(id, password);
	}

	@Override
	public void insert(AccountsDTO dto) {
		accountsDAO.insert(dto);

	}

	@Override
	public long randkey(String id) {
		return accountsDAO.randkey(id);
	}

	@Override
	public void updateRandkey(String id) {
		accountsDAO.updateRandkey(id);

	}

}
