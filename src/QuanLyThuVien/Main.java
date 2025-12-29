package QuanLyThuVien;
public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {System.out.println("===== ONLINE LIBRARY MENU =====");
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
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manager.addBook();
                case 2 -> manager.showBooks();
                case 3 -> manager.searchingBooks();
                case 4 -> manager.deleteBook();
                case 5 -> manager.addUser();
                case 6 -> manager.showUsers();
                case 7 -> manager.borrowBook();
                case 8 -> manager.returnBook();
                case 0 -> System.out.println("Thoát chương trình...");
                default -> System.out.println("Lựa chọn không hợp lệ!\n");
            }
        } while (choice != 0);
        scanner.close();
    }
}