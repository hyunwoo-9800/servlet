package com.hw.practice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hw.practice.vo.TodoListVO;

// 매퍼 인터페이스
public interface TodoListDao {

	// 전체 할 일 출력용
	List<TodoListVO> getAllItems();
	
	// 조건에 맞는 목록
	List<TodoListVO> getTodosByStatus(int status);

	// 할 일 추가용
	void insertItem(TodoListVO vo);
	
	// 상태 변경용
	boolean toggleStatus(int itemNum);
	
	// 할 일 삭제용
	public boolean deleteItem(int itemNum);
	
	// 중요도만 가져오기
	int getImportant(int itemNum);
	
	// 필터 처리용
	List<TodoListVO> getTodosByFilter(Map<String, Object> params);
	
	// 중요도 업데이트 토글
	int updateImportant(@Param("itemNum") int itemNum, @Param("important") int important);

} // 인터페이스 끝
