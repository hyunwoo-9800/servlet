/**
 * list.jsp에서 사용할 함수
 */

/* 완료 or 미완료 상태 변경용 */
document.addEventListener('DOMContentLoaded', function() {
	const checkboxes = document.querySelectorAll('.status-checkbox');

	checkboxes.forEach(checkbox => {
		checkbox.addEventListener('change', function(e) {
			const item = e.target.closest('.todo-item');
			const itemNum = item.dataset.id;

			fetch(window.contextPath + "/todo/updateStatus", {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json; charset=UTF-8'
				},
				body: JSON.stringify({ itemNum: itemNum })
			})
				.then(response => response.json())
				.then(result => {
					if (result.success) {
						location.reload();
					} else {
						alert('상태 변경 실패');
					}
				});
		});
	});
});

