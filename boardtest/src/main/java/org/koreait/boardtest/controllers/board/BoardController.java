package org.koreait.boardtest.controllers.board;

import groovy.transform.Final;
import jakarta.validation.Valid;
import org.koreait.boardtest.models.board.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
	private BoardForm boardForm;

	@Autowired
	private BoardSaveService saveService;

	@Autowired
	private BoardViewService viewService;

	@Autowired
	private BoardListService listService;

	@Autowired
	private BoardDeleteService deleteService;

	@GetMapping("/write")
	public String write(Model model){
		boardForm = new BoardForm();
		model.addAttribute("boardForm", boardForm);
		return "board/write";
	}

	@PostMapping("/write")
	public String writePs(@Valid BoardForm boardForm, Errors errors){
		try{
			saveService.save(boardForm);
		}catch(Exception e){
			errors.reject("BadRequestException", e.getMessage());
		}
		if(errors.hasErrors()){
			return "board/write";
		}
		return "redirect:/board/list";
	}

	@GetMapping("/details/{id}")
	public String details(@PathVariable Long id, Model model){
		Board board = new Board();
		board = viewService.view(id);
		/*
		try{
			board = viewService.view(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		 */
		model.addAttribute("board", board);
		return "board/details";
	}

	@GetMapping("/list")
	public String boards(Model model){
		List<Board> boardList = listService.getList();
		model.addAttribute("boardList", boardList);
		return "board/list";
	}

	@GetMapping("/delete")
	public String delete(Long id, Model model){
		deleteService.deleteBoard(id);

		return "redirect:/board/list";
	}
}
