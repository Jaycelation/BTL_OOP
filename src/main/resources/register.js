// Function to toggle password visibility
function togglePasswordVisibility(id) {
    if (!id) return; // Check if id is undefined or null

    const passwordField = document.getElementById(id);
    if (!passwordField) return; // Check if the password field exists

    const passwordToggle = document.getElementById(`toggle${id.charAt(0).toUpperCase() + id.slice(1)}`);
    if (!passwordToggle) return; // Check if the toggle button exists

    // Toggle password visibility
    passwordField.type = passwordField.type === 'password' ? 'text' : 'password';
    passwordToggle.classList.toggle('fa-eye-slash');
}

// Handle registration form submission
document.getElementById('registerForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent form submission if there are errors

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    const errorMessage = document.getElementById('errorMessage');

    // Check if password and confirm password match
    if (password !== confirmPassword) {
        errorMessage.style.color = 'red';
        errorMessage.textContent = 'Passwords do not match!'; // Error message in English
    } else {
        errorMessage.style.color = 'green';
        errorMessage.textContent = 'Registration successful!'; // Success message
        // Send registration request to the server
        const registerData = { name, email, password };

        fetch('http://localhost:8080/api/v1/auth/register', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(registerData)
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    errorMessage.style.color = 'green';
                    errorMessage.textContent = 'Registration successful!';
                } else {
                    errorMessage.style.color = 'red';
                    errorMessage.textContent = 'An error occurred. Please try again.';
                }
            })
            .catch(error => {
                console.error('Error:', error);
                errorMessage.style.color = 'red';
                errorMessage.textContent = 'An error occurred. Please try again later.';
            });
    }
});

// Ensure that toggle events are applied to both password and confirm password icons
document.getElementById('togglePassword').addEventListener('click', () => togglePasswordVisibility('password'));
document.getElementById('toggleConfirmPassword').addEventListener('click', () => togglePasswordVisibility('confirmPassword'));
