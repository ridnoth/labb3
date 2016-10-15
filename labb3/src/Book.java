
import java.util.ArrayList;

/**
 *
 * @author Hampus Glantz and Fatih Yalcin
 */
public class Book implements java.io.Serializable {

    private final String isbn;
    private final String title;
    private final int edition;
    private final double price;
    private final ArrayList<Author> authors;
/**
 *Creates a new book with parameters 
 */
    public Book(String isbn, String title, int edition, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.price = price;
        this.authors = new ArrayList<>();
        addAuthor(author);
    }
/**
 *Creates a new standard book without taking in parameters 
 */
    public Book() {
        this.isbn = "0123456789";
        this.title = "City of Thieves";
        this.edition = 17;
        this.price = 199.99;
        this.authors = new ArrayList<>();
        addAuthor("Johnboll Magnusson");
    }
/**
 *Returns ISBN of the book
     * @return 
 */
    public String getISBN() {
        return isbn;
    }
/**
 *Returns Title of the book
 */
    public String getTitle() {
        return title;
    }

    public int getEdition() {
        return edition;
    }
/**
 *Returns Price of the book
 */
    public double getPrice() {
        return price;
    }
/**
 *Adds more Authors to the book
 */
    public void addAuthor(String author) {
        Author a = new Author(author);
        authors.add(a);
    }
/**
 *Returns all Authors of the book
 */    
    public String getAuthors() {
        String info = "";
        for (Author author : authors) {
            info += author.getAuthor() + " ";
        }
        return info;
    }

    @Override
    public String toString() {
        String info
                = "ISBN: " + isbn + " Book Title: " + title + " Edition: "
                + edition + " Price: " + price + " Authors: " + getAuthors();
        info += "\n";
        return info;
    }
}
