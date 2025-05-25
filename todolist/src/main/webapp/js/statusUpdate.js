/**
 * list.jsp에서 사용할 함수
 */

/* 완료 or 미완료 상태 변경용 */
document.addEventListener('DOMContentLoaded', function() {
	// 할 일 항목들 (상태 변경)
	const items = document.querySelectorAll('.todo-item');

	// 각 항목 클릭 시 상태 변경
	items.forEach(item => {
		item.addEventListener('click', (e) => {
			// 삭제 버튼 클릭이 아닌 경우에만 상태 변경
			if (!e.target.classList.contains('delete-btn')) {
				const itemNum = item.dataset.id;

				// 상태 변경 요청 (완료/미완료)
				fetch(window.contextPath + "/todo/updateStatus", {
					method: 'POST',
					headers: { 'Content-Type': 'application/json' },
					body: JSON.stringify({ itemNum: itemNum })
				})
					.then(response => response.json())
					.then(result => {
						if (result.success) {
							location.reload(); // 갱신
						} else {
							alert('상태 변경 실패');
						}
					});
			}
		});
	});

});

