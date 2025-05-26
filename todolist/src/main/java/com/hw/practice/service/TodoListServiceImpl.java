package com.hw.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.practice.dao.TodoListDao;
import com.hw.practice.vo.TodoListVO;

@Service
// 서비스 인터페이스 구현 객체
public class TodoListServiceImpl implements TodoListService {

	// 매퍼 인스턴스화
	@Autowired
	private TodoListDao dao;

	// 모든 목록
	@Override
	public List<TodoListVO> getAllItems() {
		// TODO Auto-generated method stub
		return dao.getAllItems();
	}

	// 할 일 추가
	@Override
	public void insertItem(TodoListVO vo) {
		// TODO Auto-generated method stub
		dao.insertItem(vo);
	}

	// 상태 업데이트
	@Override
	public boolean toggleStatus(int itemNum) {
		// TODO Auto-generated method stub
		return dao.toggleStatus(itemNum);
	}

	// 할 일 삭제
	@Override
	public boolean deleteItem(int itemNum) {
		return dao.deleteItem(itemNum);
	}

	// 해당하는 목록만 가져오기
	@Override
	public List<TodoListVO> getTodosByStatus(int status) {
		// TODO Auto-generated method stub
		return dao.getTodosByStatus(status);
	}

} // class 끝
