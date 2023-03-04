package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.board.dto.EmployeeVO;

@Mapper
public interface BoardDao {
	//회원 리스트
	List<EmployeeVO> listBoard(String key);
	//회원 삭제
	void deleteList(String num);
	//회원번호 조회
	List<EmployeeVO> listNum(String key);
	//회원 등록
	void insertList(@Valid EmployeeVO employeevo);
	//회원 조회
	EmployeeVO boardListOne(String num);
	//회원 수정
	void updateList(@Valid EmployeeVO employeevo);
}
