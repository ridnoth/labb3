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
        //System.out.println(book1.toString());
        CollectionOfBooks cob= new CollectionOfBooks();
        cob.addBook(book1);
        cob.addBook(book1);
        System.out.println(cob.getBookByISBN("C"));
    }
}
