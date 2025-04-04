function matchPassword() {
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('rpassword').value;
    const errorElement = document.getElementById('password-error');

    if (confirmPassword !== password) {
        errorElement.style.display = 'block';
        document.getElementById('rpassword').classList.add('is-invalid');
        return false;
    } else {
        errorElement.style.display = 'none';
        document.getElementById('rpassword').classList.remove('is-invalid');
        return true;
    }
}

// Real-time password matching validation
document.getElementById('rpassword').addEventListener('input', function() {
    const password = document.getElementById('password').value;
    const confirmPassword = this.value;
    const errorElement = document.getElementById('password-error');

    if (confirmPassword && confirmPassword !== password) {
        errorElement.style.display = 'block';
        this.classList.add('is-invalid');
    } else {
        errorElement.style.display = 'none';
        this.classList.remove('is-invalid');
    }
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
