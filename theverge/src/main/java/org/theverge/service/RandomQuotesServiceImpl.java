package org.theverge.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.theverge.dao.RandomQuotesDAO;
import org.theverge.dto.RandomQuotesDTO;

@Service
public class RandomQuotesServiceImpl implements RandomQuotesService{
	@Inject
	RandomQuotesDAO randomQuotesDAO;

	@Override
	public RandomQuotesDTO getQuotes() {
		return randomQuotesDAO.getQuotes();
	}

}
