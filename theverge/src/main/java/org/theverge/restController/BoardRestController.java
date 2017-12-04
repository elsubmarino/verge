package org.theverge.restController;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.theverge.service.BoardService;

@RestController
public class BoardRestController {
	@Inject
	BoardService boardService;

	@RequestMapping(value = "/imageBoard/{delete}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteImagePost(@PathVariable("delete") int delete) {
		System.out.println("BoardDelete");
		boardService.deleteFromRest(delete);

		/*
		 * return "redirect:/board?category=" + dto.getCategory() + "&num=" +
		 * dto.getNum() + "&lvl=" + dto.getLvl() + "&groupNum=" +
		 * dto.getGroupNum() + "&sequence=" + dto.getSequence();
		 */
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

}
