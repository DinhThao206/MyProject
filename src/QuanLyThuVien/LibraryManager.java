package QuanLyThuVien;
public class LibraryManager {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public LibraryManager() {
        books.add(new Book(1, "Giải thích Thành ngữ - Tục ngữ", "Nhiều tác giả"));
        books.add(new Book(2, "Phong thần diễn nghĩa", "Hứa Trọng Lâm"));
        books.add(new Book(3, "Kho tàng truyện cổ tích Việt Nam", "Nhiều tác giả"));
        books.add(new Book(4, "Truyện ngắn Nam Cao", "Nam Cao"));
        books.add(new Book(5, "Truyện Trạng Quỳnh", "Dân gian"));
        books.add(new Book(6, "Tam quốc diễn nghĩa", "La Quán Trung"));
        books.add(new Book(7, "Tắt đèn", "Ngô Tất Tố"));
        books.add(new Book(8, "Số đỏ", "Vũ Trọng Phụng"));
        books.add(new Book(9, "Hồng lâu mộng", "Tào Tuyết Cần"));
        books.add(new Book(10, "Tây du ký", "Ngô Thừa Ân"));
    }

    public void addBook() {
        System.out.print("Nhập ID sách: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tên sách: ");
        String title = scanner.nextLine();

        System.out.print("Tên tác giả: ");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Thêm sách thành công!\n");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Thêm sách thành công:\n");
            return;
        }
        System.out.println("===== DANH SÁCH SÁCH =====");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void searchingBooks() {
        System.out.print("Nhập tên sách cần tìm: ");
        String searchTitle = scanner.nextLine().toLowerCase().trim();

        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().trim().contains(searchTitle)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println(" Không tìm thấy sách phù hợp!\n");
        }
    }

    public void deleteBook() {
        System.out.print("Nhập ID sách cần xoá: ");
        int id = scanner.nextInt();
        boolean removed = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                removed = true;
                break;
            }
        }

        System.out.println(removed ? "Đã xoá!\n" : "Không tìm thấy sách!\n");
    }

    public void addUser(){
        System.out.print("Nhập ID người dùng: ");
        int uid = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên người dùng: ");
        String name = scanner.nextLine();

        users.add(new User(uid, name));
        System.out.print("Thêm người dùng thành công.\n ");
    }
//Hiển thị người dùng

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("Không có người dùng.\n");
            return;
        }
        System.out.println("===== DANH SÁCH NGƯỜI DÙNG =====");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
        System.out.println();
    }
    //Mượn sách
    public void borrowBook(){
        System.out.print("Nhập ID người dùng: \n");
        int uid = scanner.nextInt();

        System.out.print("Nhập ID sách: \n");
        int bid = scanner.nextInt();

        Book targetBook = null;
        User targetUser = null;

        for (User user : users) {
            if (user.getUserId() == uid) {
                targetUser = user;
                break;
            }
        }

        for (Book book  : books) {
            if (book.getId() == bid) {
                targetBook = book;
                break;
            }
        }
        if (targetUser == null && targetBook == null) {
            System.out.println("Cả người dùng và sách đều không tồn tại. Mượn sách thất bại!\n");
            return;
        }
        if (targetUser == null) {
            System.out.println("Người dùng không tồn tại. Mượn sách thất bại!\n");
            return;
        }
        if (targetBook == null) {
            System.out.println("Sách không tồn tại. Mượn sách thất bại!\n");
            return;
        }
        if (targetBook.isBorrowed()) {
            System.out.println("Sách đang được mượn bởi người khác!\n");
            return;
        }
        targetBook.setBorrowed(true);
        System.out.println("Người dùng: " + targetUser.getName() + "Mượn sách thành công!" +"\n ");
    }
    //Trả sách
    public void returnBook() {
        System.out.print("Nhập ID sách muốn trả: ");
        int bid = scanner.nextInt();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == bid) {
                books.get(i).setBorrowed(false);
                System.out.println("Trả sách thành công!\n");
                return;
            }
        }

        System.out.println("Không tìm thấy sách!\n");
    }

}