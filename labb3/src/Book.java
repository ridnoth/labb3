
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
    
    public Book(String isbn, String title, int edition, double price, String author){
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.price = price;
        this.authors = new ArrayList<>();
        addAuthor(author);
    }
    
    public Book(){
        this.isbn = "0123456789";
        this.title = "City of Thieves";
        this.edition = 17;
        this.price = 199.99;
        this.authors = new ArrayList<>();
        addAuthor("Johnboll Magnusson");
    }
    
    public void addAuthor(String author){
        Author a = new Author(author);
        authors.add(a);
    }
    
    @Override
    public String toString(){
        String info 
                = "ISBN: " + isbn + " Book Title: " + title + " Edition: "
                + edition + " Price: " + price + " Authors: " + authors.get(0);
        return info;
    }
}
