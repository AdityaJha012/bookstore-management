document.addEventListener('DOMContentLoaded', function() {
    // Handle delete button click
    const deleteModal = document.getElementById('deleteModal');

    deleteModal.addEventListener('show.bs.modal', function(event) {
        // Button that triggered the modal
        const button = event.relatedTarget;

        // Extract info from data attributes
        const bookId = button.getAttribute('data-id');
        const bookName = button.getAttribute('data-name');

        // Update the modal's content
        const modalBookName = document.getElementById('bookName');
        const confirmDeleteBtn = document.getElementById('confirmDeleteBtn');

        modalBookName.textContent = bookName;
        confirmDeleteBtn.href = 'delete-book?id=' + bookId;
    });
});
