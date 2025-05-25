package com.hw.practice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hw.practice.service.TodoListService;
import com.hw.practice.vo.TodoListVO;

@Controller
public class TodoController {

	@Autowired
	private TodoListService service;

	// 메인화면 컨트롤러
	@GetMapping({"/", "/todo"})
	public String list(Model model) {

		List<TodoListVO> todoList = service.getAllItems();
		model.addAttribute("todoList", todoList);
		return "index";
	}

	@PostMapping("/todo/updateStatus")
	@ResponseBody
	public Map<String, Object> updateStatus(@RequestBody Map<String, String> request) {

		int itemNum = Integer.parseInt(request.get("itemNum"));
		boolean success = service.toggleStatus(itemNum);

		Map<String, Object> response = new HashMap<>();
		response.put("success", success);
		return response;
	}

	@PostMapping("/todo/add")
	public String addTodo(@RequestParam("content") String content) {

		TodoListVO todo = new TodoListVO();

		todo.setContent(content);
		todo.setStatus("0"); // 기본값: 미완료

		service.insertItem(todo);

		return "redirect:/todo"; // 목록 다시 보기
	}

	@PostMapping("/todo/delete")
	@ResponseBody
	public Map<String, Object> deleteTodo(@RequestBody Map<String, String> request) {
		int itemNum = Integer.parseInt(request.get("itemNum"));
		boolean success = service.deleteItem(itemNum); // 서비스에서 삭제 처리

		Map<String, Object> response = new HashMap<>();
		response.put("success", success);
		return response;
	}

} // class 끝
