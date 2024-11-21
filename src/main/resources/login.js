document.getElementById('loginForm').addEventListener('submit', async (e) => {
    e.preventDefault(); // Ngăn trình duyệt tải lại trang khi gửi form

    // Lấy thông tin đăng nhập từ form
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const loginData = {
        email: email,
        password: password,
    };

    // URL API
    const loginUrl = 'http://localhost:8080/api/v1/auth/login';

    try {
        // Gửi yêu cầu đăng nhập
        const response = await fetch(loginUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(loginData),
        });

        const data = await response.json();
        const errorMessage = document.getElementById('errorMessage');

        if (response.ok && data.data && data.data.access_token) {
            // Lưu JWT và refresh token vào sessionStorage
            sessionStorage.setItem('accessToken', data.data.access_token);
            sessionStorage.setItem('refreshToken', data.data.refresh_token); // Lưu refresh_token
            sessionStorage.setItem('id', data.data.id);
            sessionStorage.setItem('tokenExpiredSeconds', data.data.token_expired_seconds);
            sessionStorage.setItem('refreshExpiredSeconds', data.data.refresh_expired_seconds);
            sessionStorage.setItem('tokenType', data.data.token_type);

            // Hiển thị thông báo thành công
            errorMessage.style.color = 'green';
            errorMessage.textContent = 'Đăng nhập thành công!';

            // Chuyển hướng đến trang chủ
            setTimeout(() => {
                window.location.href = 'index.html'; // Điều chỉnh đường dẫn nếu cần
            }, 1000); // Đợi 1 giây trước khi chuyển hướng
        } else {
            // Xử lý lỗi từ server (sai thông tin đăng nhập)
            errorMessage.style.color = 'red';
            errorMessage.textContent = data.message || 'Sai thông tin đăng nhập. Vui lòng thử lại!';
        }
    } catch (error) {
        console.error('Lỗi:', error);

        // Hiển thị thông báo lỗi kết nối
        const errorMessage = document.getElementById('errorMessage');
        errorMessage.style.color = 'red';
        errorMessage.textContent = 'Có lỗi xảy ra. Vui lòng thử lại sau!';
    }
});
