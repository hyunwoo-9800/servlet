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

	// 상태 업데이트 컨트롤러
	@PostMapping("/todo/updateStatus")
	@ResponseBody
	public Map<String, Object> updateStatus(@RequestBody Map<String, String> request) {

		int itemNum = Integer.parseInt(request.get("itemNum"));
		boolean success = service.toggleStatus(itemNum);

		Map<String, Object> response = new HashMap<>();
		response.put("success", success);
		return response;
	}

	// 할 일 추가 컨트롤러
	@PostMapping("/todo/add")
	public String addTodo(@RequestParam("content") String content,
						  @RequestParam("priority") String priority,
						  @RequestParam("category") String category
			) {

		TodoListVO todo = new TodoListVO();

		todo.setContent(content);			// 할 일 내용
		todo.setPriority(priority);			// 중요도
		todo.setCategory(category);			// 카테고리
		todo.setStatus("0"); 				// 기본값: 미완료
		
		System.out.println("입력된 내용: " + content);

		service.insertItem(todo);

		return "redirect:/todo"; // 목록 다시 보기
	}

	// 할 일 삭제 컨트롤러
	@PostMapping("/todo/delete")
	@ResponseBody
	public Map<String, Object> deleteTodo(@RequestBody Map<String, String> request) {
		int itemNum = Integer.parseInt(request.get("itemNum"));
		boolean success = service.deleteItem(itemNum); // 서비스에서 삭제 처리

		Map<String, Object> response = new HashMap<>();
		response.put("success", success);
		return response;
	}
	
	// 필터 처리
	@GetMapping("/todoList")
	public String getTodoList(
	    @RequestParam(value = "filter", required = false) String filter,
	    @RequestParam(value = "category", required = false) String category,
	    @RequestParam(value = "priority", required = false) String priority,
	    @RequestParam(value = "important", required = false) String important,
	    Model model
	) {
	    Map<String, Object> params = new HashMap<>();

	    if (filter != null && !filter.equals("all")) {
	    	
	        params.put("status", Integer.parseInt(filter));
	        
	    }
	    if (category != null && !category.isEmpty()) {
	    	
	        params.put("category", category);
	        
	    }
	    if (priority != null && !priority.isEmpty()) {
	    	
	        params.put("priority", priority);
	        
	    }
	    if (important != null && !important.isEmpty()) {
	    	
	        params.put("important", Integer.parseInt(important));
	        
	    }

	    List<TodoListVO> list = service.getTodosByFilter(params);
	    model.addAttribute("todoList", list);
	    return "index";
	}
	
	// 중요도 토글 업데이트
	@PostMapping("/todo/toggleImportant")
	@ResponseBody
	public Map<String, Object> toggleImportant(@RequestBody Map<String, Object> request) {
		
	    int itemNum = Integer.parseInt(request.get("itemNum").toString());
	    int current = service.getImportant(itemNum);
	    int newValue = current == 0 ? 1 : 0;
	    
	    service.updateImportant(itemNum, newValue);
	    return Map.of("success", true);
	    
	}
	
} // class 끝
