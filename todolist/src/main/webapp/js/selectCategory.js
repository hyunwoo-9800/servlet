/* addList.jsp에서 카테고리 선택용 */
document.addEventListener('DOMContentLoaded', function() {
	const buttons = document.querySelectorAll('.category');
	const hiddenInput = document.getElementById('selectedCategory');

	buttons.forEach(button => {
		button.addEventListener('click', function() {
			buttons.forEach(btn => btn.classList.remove('active'));
			this.classList.add('active');
			hiddenInput.value = this.getAttribute('value');
		});
	});
});