package org.theverge.dao;

import java.util.List;

import org.theverge.dto.SubCategoryDTO;

public interface SubCategoryDAO {
	public List<SubCategoryDTO> getNames(int num);
}
