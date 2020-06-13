package kr.co.lifesaver.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.lifesaver.domain.LifeSaver_BoardDTO;
import kr.co.lifesaver.persistance.BoardDAO;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardDAO dao;
	
	@RequestMapping(value = "/writeform", method = RequestMethod.POST)
	public String writeformIndex(LifeSaver_BoardDTO dto) {
		logger.info("board/writeView");
		dao.insertBoard(dto);
		
		return "redirect:/board";
	}
	
	
	
	
}
