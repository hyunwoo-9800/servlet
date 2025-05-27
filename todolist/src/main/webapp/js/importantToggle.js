/* list.jsp에서 중요도 업데이트 토글 */

document.addEventListener('DOMContentLoaded', function() {
	const importantButtons = document.querySelectorAll('.important');

	importantButtons.forEach(button => {
		button.addEventListener('click', function(e) {
			e.preventDefault();

			const todoItem = button.closest('.todo-item');
			const itemId = todoItem.dataset.id;

			fetch(`${window.contextPath}/todo/toggleImportant`, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({ itemNum: itemId })
			})
				.then(res => res.json())
				.then(data => {
					if (data.success) {
						// 아이콘 색상 토글
						const icon = button.querySelector('i');
						if (icon.style.color === 'rgb(255, 212, 59)') {
							icon.style.color = '#bec4cf';
						} else {
							icon.style.color = '#FFD43B';
						}
					} else {
						alert('중요도 변경 실패');
					}
				});
		});
	});
});