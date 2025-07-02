import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem {

    // Book Class
    static class Book {
        private int id;
        private String title;
        private boolean isAvailable;

        // Constructor
        public Book(int id, String title) {
            this.id = id;
            this.title = title;
            this.isAvailable = true; // By default, the book is available
        }

        // Getter and setter for id
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        // Getter and setter for title
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        // Getter and setter for availability
        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }

        @Override
        public String toString() {
            return "Book{id=" + id + ", title='" + title + "', isAvailable=" + isAvailable + "}";
        }
    }

    // User Class
    static class User {
        private int userId;
        private String name;
        private List<Book> issuedBooks;

        // Constructor
        public User(int userId, String name) {
            this.userId = userId;
            this.name = name;
            this.issuedBooks = new ArrayList<>();
        }

        // Getter and setter for userId
        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        // Getter and setter for name
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Getter for issuedBooks
        public List<Book> getIssuedBooks() {
            return issuedBooks;
        }

        // Issue a book
        public void issueBook(Book book) {
            issuedBooks.add(book);
        }

        // Return a book
        public void returnBook(Book book) {
            issuedBooks.remove(book);
        }

        @Override
        public String toString() {
            return "User{id=" + userId + ", name='" + name + "', issuedBooks=" + issuedBooks + "}";
        }
    }

    // Library Class
    static class Library {
        private Map<Integer, Book> books; // Map of books (Book ID -> Book)
        private Map<Integer, User> users; // Map of users (User ID -> User)

        // Constructor
        public Library() {
            books = new HashMap<>();
            users = new HashMap<>();
        }

        // Add a book to the library
        public void addBook(Book book) {
            books.put(book.getId(), book);
        }

        // Add a user to the library
        public void addUser(User user) {
            users.put(user.getUserId(), user);
        }

        // Issue a book to a user
        public void issueBook(int userId, int bookId) {
            User user = users.get(userId);
            Book book = books.get(bookId);

            if (user == null || book == null) {
                System.out.println("Invalid user or book.");
                return;
            }

            if (book.isAvailable()) {
                user.issueBook(book);
                book.setAvailable(false); // Mark the book as unavailable
                System.out.println("Book issued: " + book.getTitle());
            } else {
                System.out.println("Book is not available for issue.");
            }
        }

        // Return a book from a user
        public void returnBook(int userId, int bookId) {
            User user = users.get(userId);
            Book book = books.get(bookId);

            if (user == null || book == null) {
                System.out.println("Invalid user or book.");
                return;
            }

            if (user.getIssuedBooks().contains(book)) {
                user.returnBook(book);
                book.setAvailable(true); // Mark the book as available
                System.out.println("Book returned: " + book.getTitle());
            } else {
                System.out.println("This book was not issued to the user.");
            }
        }

        // Display all books in the library
        public void displayBooks() {
            System.out.println("Books in Library:");
            for (Book book : books.values()) {
                System.out.println(book);
            }
        }

        // Display all users in the library
        public void displayUsers() {
            System.out.println("Users in Library:");
            for (User user : users.values()) {
                System.out.println(user);
            }
        }
    }

    public static void main(String[] args) {
        // Create Library
        Library library = new Library();

        // Add books
        Book book1 = new Book(1, "Java Programming");
        Book book2 = new Book(2, "Data Structures");
        Book book3 = new Book(3, "Design Patterns");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Add users
        User user1 = new User(101, "Alice");
        User user2 = new User(102, "Bob");

        library.addUser(user1);
        library.addUser(user2);

        // Display all books and users
        library.displayBooks();
        library.displayUsers();

        // Issue books
        library.issueBook(101, 1);  // Alice issues Java Programming
        library.issueBook(102, 2);  // Bob issues Data Structures

        // Display after issuing books
        library.displayBooks();
        library.displayUsers();

        // Return books
        library.returnBook(101, 1); // Alice returns Java Programming
        library.returnBook(102, 2); // Bob returns Data Structures

        // Display after returning books
        library.displayBooks();
        library.displayUsers();
    }
}
