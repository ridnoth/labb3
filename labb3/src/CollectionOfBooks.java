
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Glantz
 */
public class CollectionOfBooks {

    private ArrayList<Book> books;

    public CollectionOfBooks() {
        books = new ArrayList<>();

    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook() {

    }

    public ArrayList<Book> getBookByTitle(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public ArrayList<Book> getBookByISBN(String isbn) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : foundBooks) {
            if (isbn.contains(book.getISBN())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public ArrayList<Book> getBookByAuthor(Author author) {

        return books;
    }
    
}
