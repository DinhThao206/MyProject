package QuanLyThuVien;

import java.util.ArrayList;
import java.util.Scanner;

// Lớp LibraryManager chịu trách nhiệm quản lý:
// - Danh sách sách
// - Danh sách người dùng
// - Chức năng mượn/trả sách
public class LibraryManager {

    // Danh sách lưu trữ các sách trong thư viện
    private ArrayList<Book> books = new ArrayList<>();
    // Danh sách lưu trữ các người dùng
    private ArrayList<User> users = new ArrayList<>();
    // Đối tượng Scanner để nhập dữ liệu từ bàn phím
    private Scanner sc = new Scanner(System.in);

    // =============================
    // 1) Chức năng thêm sách mới
    // =============================
    public void addBook() {
        System.out.print("Nhập ID sách: ");
        int id = sc.nextInt();   // Nhập ID sách
        sc.nextLine();           // Xóa bỏ ký tự xuống dòng còn lại trong buffer

        System.out.print("Tên sách: ");
        String title = sc.nextLine(); // Nhập tên sách

        System.out.print("Tác giả: ");
        String author = sc.nextLine(); // Nhập tên tác giả

        // Tạo đối tượng Book mới và thêm vào danh sách
        books.add(new Book(id, title, author));
        System.out.println("Thêm sách thành công!\n");
    }

    // =====================================
    // 2) Chức năng hiển thị toàn bộ sách
    // =====================================
    public void showBooks() {
        // Nếu danh sách rỗng thì thông báo
        if (books.isEmpty()) {
            System.out.println("Không có sách.\n");
            return;
        }

        System.out.println("===== DANH SÁCH SÁCH =====");
        // Duyệt qua danh sách sách bằng vòng lặp for thường
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i)); // Gọi toString() của từng Book
        }
        System.out.println();
    }

    // ============================================
    // 3) Chức năng tìm sách theo tên (từ khóa)
    // ============================================
    public void searchBook() {
        System.out.print("Nhập tên sách: ");
        String keyword = sc.nextLine().toLowerCase(); // Chuyển về chữ thường để tìm kiếm không phân biệt hoa/thường
        boolean found = false; // Cờ kiểm tra có tìm thấy hay không

        // Duyệt tất cả sách, kiểm tra xem chuỗi biểu diễn sách có chứa từ khóa không
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).toString().toLowerCase().contains(keyword)) {
                System.out.println(books.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy!\n");
        }
    }

    // ======================================
    // 4) Chức năng xoá sách theo ID
    // ======================================
    public void deleteBook() {
        System.out.print("Nhập ID sách cần xoá: ");
        int id = sc.nextInt();  // Nhập ID cần xoá
        boolean removed = false;

        // Duyệt danh sách để tìm đúng sách có ID trùng
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i); // Xoá sách khỏi danh sách
                removed = true;
                break;           // Thoát vòng lặp sau khi xoá
            }
        }

        System.out.println(removed ? "Đã xoá!\n" : "Không tìm thấy sách!\n");
    }

    // ======================================
    // 5) Chức năng thêm người dùng mới
    // ======================================
    public void addUser() {
        System.out.print("Nhập User ID: ");
        int uid = sc.nextInt(); // Nhập ID người dùng
        sc.nextLine();          // Xoá bỏ ký tự xuống dòng

        System.out.print("Tên người dùng: ");
        String name = sc.nextLine(); // Nhập tên người dùng

        // Tạo và thêm User vào danh sách
        users.add(new User(uid, name));
        System.out.println("Thêm người dùng thành công!\n");
    }

    // =========================================
    // 6) Chức năng hiển thị danh sách người dùng
    // =========================================
    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("Không có người dùng.\n");
            return;
        }

        System.out.println("===== DANH SÁCH NGƯỜI DÙNG =====");
        // Duyệt và in ra từng User
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
        System.out.println();
    }

    // ======================================
    // 7) Chức năng mượn sách
    // ======================================
    public void borrowBook() {
        System.out.print("Nhập User ID: ");
        int uid = sc.nextInt(); // Nhập ID người dùng ( hiện tại demo chưa kiểm tra tồn tại )
        // Có thể bổ sung kiểm tra user tồn tại ở bước nâng cấp

        System.out.print("Nhập ID sách muốn mượn: ");
        int bid = sc.nextInt(); // Nhập ID sách muốn mượn

        Book targetBook = null;

        // Tìm sách có ID trùng với bid
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == bid) {
                targetBook = books.get(i);
                break;
            }
        }

        // Nếu không tìm thấy sách
        if (targetBook == null) {
            System.out.println("Không tìm thấy sách!\n");
            return;
        }

        // Nếu sách đã có người mượn rồi
        if (targetBook.isBorrowed()) {
            System.out.println("Sách đã được mượn!\n");
            return;
        }

        // Đánh dấu sách là đã mượn
        targetBook.setBorrowed(true);
        System.out.println("Mượn sách thành công!\n");
    }

    // ======================================
    // 8) Chức năng trả sách
    // ======================================
    public void returnBook() {
        System.out.print("Nhập ID sách muốn trả: ");
        int bid = sc.nextInt(); // Nhập ID sách cần trả

        // Duyệt danh sách để tìm sách này
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == bid) {
                books.get(i).setBorrowed(false); // Đặt lại trạng thái là "chưa mượn"
                System.out.println("Trả sách thành công!\n");
                return;
            }
        }

        // Nếu không sách nào có ID trùng
        System.out.println("Không tìm thấy sách!\n");
    }
}
