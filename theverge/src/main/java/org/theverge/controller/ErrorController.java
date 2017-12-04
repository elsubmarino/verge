package org.theverge.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*@ControllerAdvice
public class ErrorController {
	@ExceptionHandler(Exception.class)
	public ModelAndView errorControl(Exception ex) {
		System.out.println("Exception Controller");
		ModelAndView mav = new ModelAndView();
		mav.addObject("ex", ex);
		mav.setViewName("/exception");
		return mav;
	}
	
}
*/