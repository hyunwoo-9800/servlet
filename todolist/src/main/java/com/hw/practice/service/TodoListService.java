package com.hw.practice.service;

import java.util.List;
import java.util.Map;

import com.hw.practice.vo.TodoListVO;

// 서비스 인터페이스
public interface TodoListService {

	// 전체 목록
	List<TodoListVO> getAllItems();
	
	// 조건에 맞는 목록
	List<TodoListVO> getTodosByStatus(int status);

	// 할 일 등록
	void insertItem(TodoListVO vo);

	// 상태 업데이트
	boolean toggleStatus(int itemNum);

	// 할 일 삭제
	public boolean deleteItem(int itemNum);
	
	// 중요도만 가져오기
	int getImportant(int itemNum);
	
	// 필터 처리용
	List<TodoListVO> getTodosByFilter(Map<String, Object> params);
	
	// 중요도 업데이트용
	int updateImportant(int itemNum, int important);
	

} // 인터페이스 끝
