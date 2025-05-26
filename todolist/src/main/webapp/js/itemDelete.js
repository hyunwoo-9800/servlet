/**
 * list.jsp에서 사용할 함수
 */

/* 할 일 삭제용 */
document.addEventListener('DOMContentLoaded', function() {
	// 삭제 버튼들
	const deleteBtns = document.querySelectorAll('.delete-btn'); // 삭제 버튼들

	// 각 삭제 버튼 클릭 시 할 일 삭제
	deleteBtns.forEach(button => {
		button.addEventListener('click', () => {
			const itemNum = button.dataset.id; // 삭제할 항목의 ID

			// 삭제 요청
			fetch(window.contextPath + "/todo/delete", {
				method: 'POST',
				headers: { 'Content-Type': 'application/json charset utf-8;' },
				body: JSON.stringify({ itemNum: itemNum })
			})
				.then(response => response.json())
				.then(result => {
					if (result.success) {
						location.reload(); // 삭제 후 페이지 갱신
					} // 성공 시 알림을 띄우지 않음
				});
		});
	});
});

