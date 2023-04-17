package org.koreait.boardtest.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("org.koreait.boardtest.controllers")
public class CommonController {
	@ExceptionHandler(RuntimeException.class)
	public String errorHandler(RuntimeException e, Model model){
		e.printStackTrace();
		model.addAttribute("message", e.getMessage());
		return "error/common";
	}
}
