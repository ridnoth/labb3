
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author Hampus Glantz and Fatih Yalcin
 */
public class CollectionOfBooks implements java.io.Serializable {

    private ArrayList<Book> books;

    public CollectionOfBooks() {
        books = new ArrayList<>();

    }

    public void addBook(Book book) {
        books.add(book);
        sortBooks(books);
    }

    public void removeBook(String title) {
        for (Book book : books) {
            if (title.toUpperCase().equals(book.getTitle().toUpperCase())) {
                books.remove(book);
                break;
            }
        }
    }

    private void sortBooks(ArrayList<Book> bookList) {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
    }

    public ArrayList<Book> getBookByTitle(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toUpperCase().contains(title.toUpperCase())) {
                foundBooks.add(book);
            }
        }
        sortBooks(foundBooks);
        return foundBooks;
    }

    public ArrayList<Book> getBookByISBN(String isbn) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getISBN().contains(isbn)) {
                foundBooks.add(book);
            }
        }
        sortBooks(foundBooks);
        return foundBooks;
    }

    public ArrayList<Book> getBookByAuthor(String author) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthors().toUpperCase().contains(author.toUpperCase())) {
                foundBooks.add(book);
            }
        }

        sortBooks(foundBooks);
        return foundBooks;
    }

    @Override
    public String toString() {
        String info = "";
        for (Book book : books) {
            info += "ISBN: " + book.getISBN() + " Book Title: " + book.getTitle() + " Edition: "
                    + book.getEdition() + " Price: " + book.getPrice() + " Authors: " + book.getAuthors();
            info += "\n";
        }
        return info;
    }
}
