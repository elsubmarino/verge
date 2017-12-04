package org.theverge.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.theverge.dto.SurveyDTO;
import org.theverge.dto.SurveyIpDTO;
import org.theverge.dto.SurveyItemsDTO;
import org.theverge.service.BigCategoryService;
import org.theverge.service.SurveyIPService;
import org.theverge.service.SurveyItemsService;
import org.theverge.service.SurveyService;
import org.theverge.util.Criteria;

@Controller
public class SurveyController {
	@Inject
	BigCategoryService bigCategoryService;
	@Inject
	SurveyService surveyService;

	@Inject
	SurveyItemsService surveyItemsService;

	@Inject
	SurveyIPService surveyIpService;

	@RequestMapping(value = { "/survey/list" })
	public String list(Model model) {
		model.addAttribute("bigCategory", bigCategoryService.getNames());
		List<SurveyDTO> list = surveyService.getList();
		model.addAttribute("list", list);
		return "/survey/list";
	}

	@RequestMapping(value = { "/survey/write" }, method = RequestMethod.GET)
	public String write(Model model) {

		return "/survey/write";
	}

	@Transactional
	@RequestMapping(value = { "/survey/write" }, method = RequestMethod.POST)
	public String writePOST(Model model, SurveyDTO dto, String[] item) {
		System.out.println(dto.getTitle());
		SurveyItemsDTO items = new SurveyItemsDTO();
		surveyService.insert(dto);
		items.setParentNum(dto.getNum());
		for (String temp : item) {
			items.setTitle(temp);
			surveyItemsService.insert(items);
		}
		return "/survey/list";
	}

	@RequestMapping("/survey/read")
	public String getRead(Model model, Criteria cri, int num) {
		List<SurveyItemsDTO> list = surveyItemsService.getList(num);
		int max = surveyItemsService.maxCount(num);
		model.addAttribute("max", max);
		model.addAttribute("list", list);
		return "/survey/read";
	}

	@Transactional
	@RequestMapping(value = "/survey/vote", method = RequestMethod.POST)
	public String vote(Model model, Criteria cri, SurveyItemsDTO surveyItemsDTO, SurveyIpDTO surveyIpDTO,HttpServletRequest request) {
		surveyIpDTO.setAddress(request.getRemoteAddr());
		if (surveyIpService.check(surveyIpDTO) != 0) {
			return "/";
		}
		System.out.println("hahaha");
		surveyIpService.insert(surveyIpDTO);
		surveyItemsDTO.setNum(surveyIpDTO.getNum());
		surveyItemsService.updateForItem(surveyItemsDTO);
		return "/survey/read";
	}

}
