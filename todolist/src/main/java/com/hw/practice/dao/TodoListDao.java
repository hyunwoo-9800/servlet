package com.hw.practice.dao;

import java.util.List;

import com.hw.practice.vo.TodoListVO;

// 매퍼 인터페이스
public interface TodoListDao {

	// 전체 할 일 출력용
	List<TodoListVO> getAllItems();

	// 할 일 추가용
	void insertItem(TodoListVO vo);
	
	// 상태 변경용
	boolean toggleStatus(int itemNum);
	
	public boolean deleteItem(int itemNum);

} // 인터페이스 끝
