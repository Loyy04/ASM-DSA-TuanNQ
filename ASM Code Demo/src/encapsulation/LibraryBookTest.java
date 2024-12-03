package encapsulation;

public class LibraryBookTest {
    public static void main(String[] args) {
        // Create a new LibraryBook object
        LibraryBook book = new LibraryBook("1984", "George Orwell");

        // Display initial book details
        System.out.println(book.getDetails());

        // Test checking out the book
        book.checkOut();
        System.out.println("Is the book available? " + book.isAvailable());

        // Test trying to check out the book again
        book.checkOut();

        // Test returning the book
        book.returnBook();
        System.out.println("Is the book available? " + book.isAvailable());

        // Test trying to return the book again
        book.returnBook();
    }
}

