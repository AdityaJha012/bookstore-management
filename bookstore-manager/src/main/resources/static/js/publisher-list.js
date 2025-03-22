document.addEventListener('DOMContentLoaded', function() {
    // Handle delete button click
    const deleteModal = document.getElementById('deleteModal');

    deleteModal.addEventListener('show.bs.modal', function(event) {
        // Button that triggered the modal
        const button = event.relatedTarget;

        // Extract info from data attributes
        const publisherId = button.getAttribute('data-id');
        const publisherName = button.getAttribute('data-name');

        // Update the modal's content
        const modalPublisherName = document.getElementById('publisherName');
        const confirmDeleteBtn = document.getElementById('confirmDeleteBtn');

        modalPublisherName.textContent = publisherName;
        confirmDeleteBtn.href = 'delete-publisher?id=' + publisherId;
    });
});
