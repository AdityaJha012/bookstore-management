document.addEventListener('DOMContentLoaded', function() {
    // Handle delete button click
    const deleteModal = document.getElementById('deleteModal');

    deleteModal.addEventListener('show.bs.modal', function(event) {
        // Button that triggered the modal
        const button = event.relatedTarget;

        // Extract info from data attributes
        const authorId = button.getAttribute('data-id');
        const authorName = button.getAttribute('data-name');

        // Update the modal's content
        const modalAuthorName = document.getElementById('authorName');
        const confirmDeleteBtn = document.getElementById('confirmDeleteBtn');

        modalAuthorName.textContent = authorName;
        confirmDeleteBtn.href = 'delete-author?id=' + authorId;
    });
});
