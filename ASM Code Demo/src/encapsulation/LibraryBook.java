package encapsulation;

public class LibraryBook {
    // Private fields to store book details
    private String title;
    private String author;
    private boolean isCheckedOut;

    // Constructor to initialize the book
    public LibraryBook(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false; // Default: Book is available
    }

    // Public method to check out the book
    public void checkOut() {
        if (!isCheckedOut) {
            isCheckedOut = true;
            System.out.println("The book \"" + title + "\" has been checked out.");
        } else {
            System.out.println("The book \"" + title + "\" is already checked out.");
        }
    }

    // Public method to return the book
    public void returnBook() {
        if (isCheckedOut) {
            isCheckedOut = false;
            System.out.println("The book \"" + title + "\" has been returned.");
        } else {
            System.out.println("The book \"" + title + "\" was not checked out.");
        }
    }

    // Public method to get the book's availability
    public boolean isAvailable() {
        return !isCheckedOut;
    }

    // Public method to get book details
    public String getDetails() {
        return "Title: " + title + ", Author: " + author + ", Available: " + !isCheckedOut;
    }
}
