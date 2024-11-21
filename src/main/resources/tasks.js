document.getElementById('home-link').addEventListener('click', function(event) {
    event.preventDefault();
    window.location.href = 'home.html';
});

// Xử lý gửi form
document.getElementById('task-form').addEventListener('submit', async function(event) {
    event.preventDefault(); // Ngăn form reload trang

    // Lấy dữ liệu từ form
    const title = document.getElementById('task-name').value;
    const description = document.getElementById('description').value;
    const date = document.getElementById('due-date').value;
    const priority = parseInt(document.getElementById('priority').value, 10);
    const status = parseInt(document.getElementById('status').value, 10);
    const user_id = sessionStorage.getItem('user_id'); // Lấy user_id từ sessionStorage

    if (!user_id) {
        alert("User ID is missing. Please log in.");
        return;
    }

    // Tạo object dữ liệu
    const taskData = {
        title,
        description,
        priority,
        status,
        date,
        user_id,
    };

    try {
        // Gửi yêu cầu POST tới API
        const response = await fetch('http://localhost:8080/api/v1/tasks', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(taskData),
        });

        if (!response.ok) {
            const error = await response.json();
            throw new Error(error.message || "Failed to add task.");
        }

        alert("Task added successfully!");
        document.getElementById('task-form').reset(); // Reset form sau khi thêm thành công
    } catch (error) {
        console.error("Error adding task:", error);
        alert("An error occurred while adding the task.");
    }
});
