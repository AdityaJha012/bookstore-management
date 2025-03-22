document.addEventListener('DOMContentLoaded', function() {
    // Handle delete button click
    const deleteModal = document.getElementById('deleteModal');

    deleteModal.addEventListener('show.bs.modal', function(event) {
        // Button that triggered the modal
        const button = event.relatedTarget;

        // Extract info from data attributes
        const categoryId = button.getAttribute('data-id');
        const categoryName = button.getAttribute('data-name');

        // Update the modal's content
        const modalCategoryName = document.getElementById('categoryName');
        const confirmDeleteBtn = document.getElementById('confirmDeleteBtn');

        modalCategoryName.textContent = categoryName;
        confirmDeleteBtn.href = 'delete-category?id=' + categoryId;
    });
});
