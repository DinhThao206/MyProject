package QuanLyThuVien;

import java.util.Scanner;

// Lớp Main là điểm bắt đầu chương trình (hàm main)
public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager(); // Tạo đối tượng quản lý thư viện
        Scanner sc = new Scanner(System.in);
        int choice; // Biến lưu lựa chọn của người dùng

        // Vòng lặp hiển thị menu cho đến khi người dùng chọn 0 để thoát
        do {
            System.out.println("===== ONLINE LIBRARY MENU =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách theo tên");
            System.out.println("4. Xóa sách");
            System.out.println("5. Thêm người dùng");
            System.out.println("6. Hiển thị người dùng");
            System.out.println("7. Mượn sách");
            System.out.println("8. Trả sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();  // Nhập lựa chọn
            sc.nextLine();          // Xóa bỏ ký tự xuống dòng

            // Xử lý lựa chọn bằng switch-case
            switch (choice) {
                case 1 -> manager.addBook();      // Gọi chức năng thêm sách
                case 2 -> manager.showBooks();    // Gọi chức năng hiển thị sách
                case 3 -> manager.searchBook();   // Gọi chức năng tìm sách
                case 4 -> manager.deleteBook();   // Gọi chức năng xoá sách
                case 5 -> manager.addUser();      // Gọi chức năng thêm người dùng
                case 6 -> manager.showUsers();    // Gọi chức năng hiển thị người dùng
                case 7 -> manager.borrowBook();   // Gọi chức năng mượn sách
                case 8 -> manager.returnBook();   // Gọi chức năng trả sách
                case 0 -> System.out.println("Thoát chương trình...");
                default -> System.out.println("Lựa chọn không hợp lệ!\n");
            }

        } while (choice != 0); // Lặp lại nếu chưa chọn 0

        sc.close(); // Đóng Scanner khi kết thúc chương trình
    }
}
