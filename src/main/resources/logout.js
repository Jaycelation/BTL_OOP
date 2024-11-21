// Lắng nghe sự kiện click trên nút LOGOUT
document.getElementById('logout-link').addEventListener('click', function(event) {
    event.preventDefault(); // Ngừng hành động mặc định của thẻ <a>

    // Xóa token khỏi localStorage
    localStorage.removeItem('accessToken');

    // Chuyển hướng đến trang login
    window.location.href = 'login.html'; // Chuyển hướng về trang đăng nhập
});
