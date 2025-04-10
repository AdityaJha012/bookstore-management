document.addEventListener('DOMContentLoaded', function() {
    // Password toggle visibility
    const toggleButtons = document.querySelectorAll('.toggle-password');
    toggleButtons.forEach(button => {
        button.addEventListener('click', function() {
            const targetId = this.getAttribute('data-target');
            const passwordInput = document.getElementById(targetId);
            const icon = this.querySelector('i');

            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                icon.classList.remove('fa-eye');
                icon.classList.add('fa-eye-slash');
            } else {
                passwordInput.type = 'password';
                icon.classList.remove('fa-eye-slash');
                icon.classList.add('fa-eye');
            }
        });
    });

    // Password strength meter
    const newPassword = document.getElementById('newPassword');
    const confirmPassword = document.getElementById('confirmPassword');
    const progressBar = document.querySelector('.progress-bar');
    const mismatchMessage = document.getElementById('passwordMismatch');
    const submitButton = document.getElementById('submitButton');

    newPassword.addEventListener('input', function() {
        const password = this.value;
        const strength = calculatePasswordStrength(password);

        progressBar.style.width = strength.score + '%';

        // Update progress bar color based on strength
        progressBar.className = 'progress-bar';
        if (strength.score < 30) {
            progressBar.classList.add('bg-danger');
        } else if (strength.score < 70) {
            progressBar.classList.add('bg-warning');
        } else {
            progressBar.classList.add('bg-success');
        }

        validateForm();
    });

    confirmPassword.addEventListener('input', function() {
        validateForm();
    });

    function validateForm() {
        const password = newPassword.value;
        const confirm = confirmPassword.value;

        if (confirm && password !== confirm) {
            confirmPassword.classList.add('is-invalid');
            mismatchMessage.style.display = 'block';
            submitButton.disabled = true;
        } else {
            confirmPassword.classList.remove('is-invalid');
            mismatchMessage.style.display = 'none';
            submitButton.disabled = false;
        }
    }

    function calculatePasswordStrength(password) {
        // Simple password strength calculator
        let score = 0;
        let feedback = '';

        // Length
        if (password.length >= 8) {
            score += 25;
        }

        // Contains number
        if (/\d/.test(password)) {
            score += 25;
        }

        // Contains lowercase
        if (/[a-z]/.test(password)) {
            score += 25;
        }

        // Contains uppercase
        if (/[A-Z]/.test(password)) {
            score += 25;
        }

        return {
            score: score,
            feedback: feedback
        };
    }

    // Form validation
    const form = document.getElementById('passwordForm');
    form.addEventListener('submit', function(e) {
        const password = newPassword.value;
        const confirm = confirmPassword.value;

        if (password !== confirm) {
            e.preventDefault();
            confirmPassword.classList.add('is-invalid');
            mismatchMessage.style.display = 'block';
        }
    });
});
