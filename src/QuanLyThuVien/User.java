package QuanLyThuVien;

// Lớp User dùng để lưu thông tin người dùng (độc giả) trong hệ thống thư viện online
public class User {
    private int userId;  // Mã người dùng (duy nhất)
    private String name; // Tên người dùng

    // Constructor khởi tạo đối tượng User
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    // Lấy userId để phục vụ việc quản lý, mượn sách...
    public int getUserId() {
        return userId;
    }

    // Hiển thị thông tin người dùng
    @Override
    public String toString() {
        return "User ID: " + userId + " | Tên: " + name;
    }
}

