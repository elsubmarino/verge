package org.theverge.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.theverge.dao.ContentsDAO;
import org.theverge.service.BigCategoryService;
import org.theverge.service.RandomQuotesService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Inject
	RandomQuotesService randomQuotesService;
	@Inject
	BigCategoryService bigCategoryService;
	@Inject
	ContentsDAO contentsDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("quote", randomQuotesService.getQuotes());
		model.addAttribute("bigCategory", bigCategoryService.getNames());
		model.addAttribute("topicsOfContents", contentsDAO.getTopics());

		return "home";
	}

	/*@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<Void> test(Locale locale, Model model) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
*/
}
