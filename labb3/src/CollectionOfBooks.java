
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
        ArrayList<Book> books = new ArrayList<>();
    }

    public void addBook(Book book) {
            books.add(book);
    }

    
    public ArrayList<Book> getBookByTitle(String title) {

        return books;
    }
}
