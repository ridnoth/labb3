/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Glantz
 */
public class main {

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("0321745", "Adventures of Java", 6, 500.75, "Elias Axelsson");
        Book book3 = new Book("0548392", "How I met Fatih", 9, 899.99, "Elias Axelsson");
        CollectionOfBooks cob = new CollectionOfBooks();
        cob.addBook(book3);
        cob.addBook(book2);
        cob.addBook(book1);
        System.out.println(cob.toString());
        //System.out.println(cob.getBookByAuthor("John"));
        //cob.removeBook("City of Thieves");
        //System.out.println(cob.getBookByTitle("C"));
    }
}
