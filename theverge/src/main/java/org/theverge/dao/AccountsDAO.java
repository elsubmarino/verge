package org.theverge.dao;

import org.theverge.dto.AccountsDTO;

public interface AccountsDAO {
	public int getResult(String id, String password);

	public void insert(AccountsDTO dto);

	public long randkey(String id);

	public void updateRandkey(String id);
}
