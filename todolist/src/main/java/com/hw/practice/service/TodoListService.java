package com.hw.practice.service;

import java.util.List;

import com.hw.practice.vo.TodoListVO;

// 서비스 인터페이스
public interface TodoListService {

	List<TodoListVO> getAllItems();

	void insertItem(TodoListVO vo);

	boolean toggleStatus(int itemNum);

	public boolean deleteItem(int itemNum);

} // 인터페이스 끝
