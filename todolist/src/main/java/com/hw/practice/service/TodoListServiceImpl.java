package com.hw.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.practice.dao.TodoListDao;
import com.hw.practice.vo.TodoListVO;

@Service
// 서비스 인터페이스 구현 객체
public class TodoListServiceImpl implements TodoListService {

	@Autowired
	private TodoListDao dao;

	@Override
	public List<TodoListVO> getAllItems() {
		// TODO Auto-generated method stub
		return dao.getAllItems();
	}

	@Override
	public void insertItem(TodoListVO vo) {
		// TODO Auto-generated method stub
		dao.insertItem(vo);
	}

	@Override
	public boolean toggleStatus(int itemNum) {
		// TODO Auto-generated method stub
		return dao.toggleStatus(itemNum);
	}

	@Override
	public boolean deleteItem(int itemNum) {
		return dao.deleteItem(itemNum);
	}

} // class 끝
