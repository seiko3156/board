package com.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.dto.EmployeeVO;
import com.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService bs;
	//게시판
	@RequestMapping("/")
	
	public ModelAndView board(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> result = bs.listBoard(request);
		
		mav.addObject("boardList",(List<EmployeeVO>)result.get("boardList"));
		mav.addObject("boardnum",(List<EmployeeVO>)result.get("boardnum"));
		mav.setViewName("board");
		
		return mav;
	}
	//회원 삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String num = request.getParameter("num");
		
		bs.deleteList(num);
		
		return "redirect:/";
	}
	
	//회원 등록폼 이동
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "/board/writeForm";
	}
	//회원등록
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute("dto") @Valid EmployeeVO employeevo, BindingResult result1, HttpServletRequest request,
			Model model) {
		
		
		String url = "/board/writeForm";
		if (result1.getFieldError("name") != null) {
			model.addAttribute("message", result1.getFieldError("name").getDefaultMessage());
		}else if (result1.getFieldError("phone") != null) {
			model.addAttribute("message", result1.getFieldError("phone").getDefaultMessage());
		}else if (result1.getFieldError("position") != null) {
			model.addAttribute("message", result1.getFieldError("position").getDefaultMessage());
		}else if (result1.getFieldError("email") != null) {
			model.addAttribute("message", result1.getFieldError("email").getDefaultMessage());
		}else{
			bs.insertList(employeevo);
			url="redirect:/";			
		}
		
		return url;
	}
	//회원 수정폼 이동
	@RequestMapping("/updateForm")
	public ModelAndView updateForm(@RequestParam("num") String num,@RequestParam(value="message",required = false) String message) {
		ModelAndView mav = new ModelAndView();
		EmployeeVO employeevo = bs.boardListOne(num);
		System.out.println(message);
		mav.addObject("message", message);
		mav.addObject("boardnum",num); //boardlist에 담긴 num의 형식이 0001이라 숫자형태로 다시 보내줌
		mav.addObject("boardList",employeevo);
		mav.setViewName("board/updateForm");
		return mav;
	}
	
	//회원수정
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(@ModelAttribute("dto") @Valid EmployeeVO employeevo, BindingResult result1, HttpServletRequest request,
				Model model,@RequestParam("num") String num,RedirectAttributes redirectAttributes) {
			
			String url = "redirect:/updateForm?num="+num;
			if (result1.getFieldError("name") != null) {
				redirectAttributes.addAttribute("message", result1.getFieldError("name").getDefaultMessage());
			}else if (result1.getFieldError("phone") != null) {
				redirectAttributes.addAttribute("message", result1.getFieldError("phone").getDefaultMessage());
			}else if (result1.getFieldError("position") != null) {
				redirectAttributes.addAttribute("message", result1.getFieldError("position").getDefaultMessage());
			}else if (result1.getFieldError("email") != null) {
				redirectAttributes.addAttribute("message", result1.getFieldError("email").getDefaultMessage());
			}else{
				employeevo.setNum(num);
				bs.updateList(employeevo);
				url="redirect:/";			
			}
			
			return url;
		}
	
	
}
