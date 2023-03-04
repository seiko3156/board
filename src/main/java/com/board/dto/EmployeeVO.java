package com.board.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmployeeVO {
	private String num;
	@NotNull(message="이름을 입력하세요")
	@NotEmpty(message="이름을 입력하세요")
	private String name;
	@NotNull(message="핸드폰번호를 입력하세요")
	@NotEmpty(message="핸드폰번호를 입력하세요")
	private String phone;
	@NotNull(message="직급을 입력하세요")
	@NotEmpty(message="직급을 입력하세요")
	private String position;
	@NotNull(message="이메일을 입력하세요")
	@NotEmpty(message="이메일을 입력하세요")
	private String email;
}
