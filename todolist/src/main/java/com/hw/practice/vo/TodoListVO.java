package com.hw.practice.vo;

import lombok.Data;

@Data
// 할 일 목록 데이터 저장용 클래스
public class TodoListVO {

	private int itemNum;		// 할 일 목록 번호(자동증가)
	private String content;		// 할 일 목록 내용
	private String status;		// 완료 / 미완료
	private String category;	// 카테고리(일반, 업무, 운동, 개인)
	private String important;	// 중요업무 체크(0 or 1)
	private String priority;	// 중요도(낮음, 보통, 높음)

} // class 끝
