package todolist.dto;

import lombok.Data;

// 할 일 목록을 저장할 클래스
@Data
public class TodoListDTO {

	private int itemNum;
	private String item;
	private String Status;
	
} // class 끝
