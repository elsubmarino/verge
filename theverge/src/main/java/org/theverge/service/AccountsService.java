package org.theverge.service;

import org.theverge.dto.AccountsDTO;

public interface AccountsService {
	public int getResult(String id, String password);

	public void insert(AccountsDTO dto);

	public long randkey(String id);

	public void updateRandkey(String id);
}
