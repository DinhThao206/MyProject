package QuanLyThuVien;

// Lớp Book dùng để lưu trữ thông tin của một cuốn sách trong thư viện online
public class Book {
    private int id;           // Mã sách (duy nhất)
    private String title;     // Tên sách
    private String author;    // Tác giả
    private boolean isBorrowed; // Trạng thái: true = đã mượn, false = còn trong thư viện

    // Constructor khởi tạo một đối tượng Book
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // Mặc định mới thêm vào là chưa được mượn
    }

    // Lấy ID sách (dùng để tìm kiếm, xoá, mượn, trả)
    public int getId() {
        return id;
    }

    // Kiểm tra sách có đang bị mượn hay không
    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Cập nhật trạng thái mượn của sách
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    // Hiển thị thông tin sách dưới dạng chuỗi
    @Override
    public String toString() {
        return "ID: " + id +
                " | Tên: " + title +
                " | Tác giả: " + author +
                " | Trạng thái: " + (isBorrowed ? "Đã mượn" : "Có sẵn");
    }
}

