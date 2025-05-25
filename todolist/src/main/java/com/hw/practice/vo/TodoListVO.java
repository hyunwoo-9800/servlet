package com.hw.practice.vo;

import lombok.Data;

@Data
// 할 일 목록 데이터 저장용 클래스
public class TodoListVO {

	private int itemNum;
	private String content;
	private String status;

} // class 끝
