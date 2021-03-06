package net.kzn.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","The page is constructed!");
		
		mv.addObject("errorDescription","The page you are looking for is not available now!");
		
		mv.addObject("title","404 Error Page");
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Product not available!");
		
		mv.addObject("errorDescription","The Product you are looking for is not available now!");
		
		mv.addObject("title","Product Unavailable");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Contact your administrator!");
		
		mv.addObject("errorDescription",ex.toString());
		
		mv.addObject("title","Error");
		
		return mv;
	}

}
