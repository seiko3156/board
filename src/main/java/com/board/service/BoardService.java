package com.board.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.dto.EmployeeVO;

@Service
public class BoardService {
	@Autowired
	BoardDao bdao;
	//회원리스트 조회
	public HashMap<String, Object> listBoard(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		String key="";
	      if (request.getParameter("key") != null) {
	         key = request.getParameter("key");
	      }
	      System.out.println(key);
	      List<EmployeeVO> list= bdao.listBoard(key);
	      List<EmployeeVO> listNum= bdao.listNum(key);
	      result.put("boardList", list);
	      result.put("boardnum", listNum);
		return result;
	}
	//회원 삭제
	public void deleteList(String num) {
		
		bdao.deleteList(num);
		
	}
	//회원 등록
	public void insertList(@Valid EmployeeVO employeevo) {
		
		bdao.insertList(employeevo);
		
	}
	//회원 조회
	public EmployeeVO boardListOne(String num) {
		EmployeeVO employeevo = bdao.boardListOne(num);
		return employeevo;
	}
	//회원 수정
	public void updateList(@Valid EmployeeVO employeevo) {
		
		bdao.updateList(employeevo);
		
	}

}
