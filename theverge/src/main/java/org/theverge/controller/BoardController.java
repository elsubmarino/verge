package org.theverge.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.theverge.dto.BoardDTO;
import org.theverge.dto.CommentsDTO;
import org.theverge.service.BigCategoryService;
import org.theverge.service.BoardService;
import org.theverge.service.CommentsService;
import org.theverge.util.Criteria;
import org.theverge.util.FileUploader;
import org.theverge.util.PageMaker;

@Controller
public class BoardController {
	@Inject
	BigCategoryService bigCategoryService;

	@Inject
	BoardService boardService;

	@Inject
	CommentsService commentsService;

	@GetMapping("/board")
	public String getList(Model model, Criteria cri, String category) {
		System.out.println(cri.getSearchType() + " _Debug:searchType");
		cri.setSearchCategory(category);
		System.out.println(cri.getPage() + " [getPage]");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int count = boardService.getTotalCount(cri);
		pageMaker.setTotalCount(count);
		List<BoardDTO> list = boardService.getList(cri);
		model.addAttribute("bigCategory", bigCategoryService.getNames());
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", list);
		return "/board/board";
	}

	@RequestMapping("/board/read")
	public String getRead(Model model, Criteria cri, int num, CommentsDTO cdto) {
		cdto.setNum(num);
		List<CommentsDTO> list = commentsService.getComments(cdto);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int count = boardService.getTotalCount(cri);
		pageMaker.setTotalCount(count);
		BoardDTO dto = boardService.getOne(num);
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
		model.addAttribute("cri",cri);
		return "/board/read";
	}

	@RequestMapping(value = "/board/write2", method = RequestMethod.GET)
	public String write(Model model, Criteria cri) {
		return "/board/write2";
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write(Model model, Criteria cri, int groupNum) {
		System.out.println(cri.getPage() + " [getPage]");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int count = boardService.getTotalCount(cri);
		pageMaker.setTotalCount(count);
		BoardDTO dto = boardService.getOne(groupNum);
		model.addAttribute("dto", dto);
		return "/board/write";
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String writePost(Model model, Criteria cri, BoardDTO dto, @RequestParam("file") MultipartFile file) {
		if (file != null) {
			new FileUploader(file, "a:\\", file.getOriginalFilename());
			dto.setFilename(file.getOriginalFilename());
		}
		System.out.println("BoardWrite");
		boardService.insert(dto);

		return "redirect:/board?category=" + dto.getCategory() + "&num=" + dto.getNum() + "&lvl=" + dto.getLvl()
				+ "&groupNum=" + dto.getGroupNum() + "&sequence=" + dto.getSequence();
	}

	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String deletePost(Model model, Criteria cri, BoardDTO dto) {
		System.out.println("BoardDelete");
		boardService.delete(dto);
		PageMaker pm=new PageMaker();
		pm.setCri(cri);;
		String url=pm.makeSearch(cri.getPage());
		return "redirect:/board"+url+"&category=" + dto.getCategory() + "&num=" + dto.getNum() + "&lvl=" + dto.getLvl()
				+ "&groupNum=" + dto.getGroupNum() + "&sequence=" + dto.getSequence();
	}

	@RequestMapping("/imageBoard/list")
	public String getImageList(Model model, Criteria cri, String category) {
		System.out.println(cri.getSearchType() + " _Debug:searchType");
		cri.setSearchCategory(category);
		System.out.println(cri.getPage() + " [getPage]");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int count = boardService.getTotalCount(cri);
		pageMaker.setTotalCount(count);
		List<BoardDTO> list = boardService.getList(cri);
		model.addAttribute("bigCategory", bigCategoryService.getNames());
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", list);
		return "/board/imageList";
	}

	@RequestMapping(value = "/imageBoard/write", method = RequestMethod.GET)
	public String writeImage(Model model, Criteria cri, int groupNum) {
		System.out.println(cri.getPage() + " [getPage]");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int count = boardService.getTotalCount(cri);
		pageMaker.setTotalCount(count);
		BoardDTO dto = boardService.getOne(groupNum);
		model.addAttribute("dto", dto);
		return "/board/write";
	}

	@RequestMapping(value = "/imageBoard/write", method = RequestMethod.POST)
	public String writeImagePost(Model model, Criteria cri, BoardDTO dto, @RequestParam("file") MultipartFile file) {
		if (file != null) {
			new FileUploader(file, "a:\\", file.getOriginalFilename());
			dto.setFilename(file.getOriginalFilename());
		}
		System.out.println("BoardWrite");
		boardService.insert(dto);

		return "redirect:/board?category=" + dto.getCategory() + "&num=" + dto.getNum() + "&lvl=" + dto.getLvl()
				+ "&groupNum=" + dto.getGroupNum() + "&sequence=" + dto.getSequence();
	}

	@RequestMapping(value = "/imageBoard/delete", method = RequestMethod.POST)
	public String deleteImagePost(Model model, Criteria cri, BoardDTO dto) {
		System.out.println("BoardDelete");
		boardService.delete(dto);

		return "redirect:/board?category=" + dto.getCategory() + "&num=" + dto.getNum() + "&lvl=" + dto.getLvl()
				+ "&groupNum=" + dto.getGroupNum() + "&sequence=" + dto.getSequence();
	}

}
