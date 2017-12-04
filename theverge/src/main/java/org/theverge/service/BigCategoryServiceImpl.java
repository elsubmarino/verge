package org.theverge.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.theverge.dao.BigCategoryDAO;
import org.theverge.dto.BigCategoryDTO;

@Service
public class BigCategoryServiceImpl implements BigCategoryService{
	@Inject
	BigCategoryDAO bigCategoryDAO;

	@Override
	public List<BigCategoryDTO> getNames() {
		return bigCategoryDAO.getNames();
	}

}
