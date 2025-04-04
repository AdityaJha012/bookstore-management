window.addEventListener('DOMContentLoaded', () => {
    const messages = document.querySelectorAll('.flash-message');
    messages.forEach(msg => {
        setTimeout(() => {
            msg.remove();
        }, 2000);
    });
});

function togglePassword(inputId) {
    const passwordInput = document.getElementById(inputId);
    const toggleIcon = passwordInput.nextElementSibling;

    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        toggleIcon.classList.remove('fa-eye');
        toggleIcon.classList.add('fa-eye-slash');
    } else {
        passwordInput.type = 'password';
        toggleIcon.classList.remove('fa-eye-slash');
        toggleIcon.classList.add('fa-eye');
    }
}
