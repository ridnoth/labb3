
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
public class Book {

    private String isbn;
    private String title;
    private int edition;
    private double price;
    private ArrayList<Author> authors;

    public Book(String isbn, String title, int edition, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.price = price;
        this.authors = new ArrayList<>();
        addAuthor(author);
    }

    public Book() {
        this.isbn = "0123456789";
        this.title = "City of Thieves";
        this.edition = 17;
        this.price = 199.99;
        this.authors = new ArrayList<>();
        addAuthor("Johnboll Magnusson");
    }

    public void addAuthor(String author) {
        Author a = new Author(author);
        authors.add(a);
    }
    
    public String getISBN(){
        return isbn;
    }
    
    public String getTitle(){
        return title;
    }
    
    public int getEdition(){
        return edition;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getAuthors(){
        String info = null;
        for(Author author : authors){
            info += author.getAuthor();
        }
        return info;
    }
    
    @Override
    public String toString() {
        String info
                = "ISBN: " + isbn + " Book Title: " + title + " Edition: "
                + edition + " Price: " + price + " Authors: ";
        for (Author author : authors) {
            info += author.getAuthor();
            info += "";
        }
        return info;
    }
}
