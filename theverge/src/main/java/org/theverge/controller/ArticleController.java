package org.theverge.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.theverge.dao.ContentsDAO;
import org.theverge.dto.CommentsDTO;
import org.theverge.dto.ContentsDTO;
import org.theverge.service.BigCategoryService;
import org.theverge.service.CommentsService;

@Controller
public class ArticleController {
	@Inject
	BigCategoryService bigCategoryService;

	@Inject
	ContentsDAO contentsDAO;
	@Inject
	CommentsService commentsService;

/*	@RequestMapping("/article")
	public String article(Model model,int num){
		model.addAttribute("bigCategory",bigCategoryService.getNames());
		ContentsDTO dto=contentsDAO.getArticle(num);
		model.addAttribute("dto",dto);
		model.addAttribute("comments",commentsDAO.getComments(num));
		return "/article/article";
	}*/

	@RequestMapping(value="/article/write",method=RequestMethod.POST)
	public String write(Model model,CommentsDTO dto){
		System.out.println(dto.getNum()+" getNum From /article/write");
		int num=dto.getNum();
		commentsService.insert(dto);
		System.out.println(dto.getNum()+" /article/write getNum");
		return "redirect:/board/read?category=" + dto.getCategory() + "&num=" + num + "&lvl=" + dto.getLvl()
		+ "&groupNum=" + dto.getGroupNum() + "&sequence=" + dto.getSequence();
	}

}
