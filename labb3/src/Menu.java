
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Hampus Glantz and Fatih Yalcin
 */
public class Menu {

    private Scanner scan;
    CollectionOfBooks cob = new CollectionOfBooks();

    public Menu() {
        scan = new Scanner(System.in);
    }

    /**
     * Check for a file named ListofBooks if not found it will print that to
     * user
     */
    public void run() throws FileNotFoundException, IOException {
        char choice = ' ';
        String answer;
        try {
            FileInputStream fileIn = new FileInputStream("ListOfBooks.lstf");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            cob = (CollectionOfBooks) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println("File not found");
        } catch (ClassNotFoundException c) {
            System.out.println("CollectionOfBooks not found");
            return;
        }
        /**
         * Main menu loop
         */
        do {
            printMenu();
            answer = scan.nextLine();
            answer = answer.toUpperCase();
            choice = answer.charAt(0); // Första tecknet i svaret

            switch (choice) {
                case 'A':
                    createBook();
                    break;
                case 'B':
                    deleteBook();
                    break;
                case 'C':
                    searchMenu();
                    break;
                case 'D':
                    printBooks();
                    break;
                case 'X':
                    System.out.println("Bye, bye!");

                    break;
                default:
                    System.out.println("Unknown command");
            }

        } while (choice != 'X');
        /**
         * Save to file
         */
        try {
            FileOutputStream fileOut = new FileOutputStream("ListOfBooks.lstf");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(cob);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ListOfBooks.lstf");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String enterISBN() {
        System.out.println("Enter ISBN: ");
        String answer = scan.nextLine();
        return answer;
    }

    private String enterTitle() {
        System.out.println("Enter Title: ");
        String answer = scan.nextLine();
        return answer;
    }

    private int enterEdition() {
        System.out.println("Enter Edition: ");
        String answer = scan.nextLine();
        int ans = Integer.parseInt(answer);
        return ans;
    }

    private double enterPrice() {
        System.out.println("Enter Price: ");
        String answer = scan.nextLine();
        double ans = Double.parseDouble(answer);
        return ans;
    }

    private String enterAuthor() {
        System.out.println("Enter an Author: ");
        String answer = scan.nextLine();
        return answer;
    }

    private void enterMoreAuthors(Book book) {
        String answer = "";
        do {
            System.out.println("Enter another author? (Y/N): ");
            answer = scan.nextLine();
            if (answer.toUpperCase().equals("Y")) {
                book.addAuthor(enterAuthor());
            }
        } while (answer.toUpperCase().equals("Y"));
    }

    /**
     * Creates a book
     */
    public void createBook() {
        Book book = new Book(enterISBN(), enterTitle(), enterEdition(), enterPrice(), enterAuthor());
        cob.addBook(book);
        enterMoreAuthors(book);
    }

    /**
     * Delete a Book
     */
    public void deleteBook() {
        printBooks();
        cob.removeBook(enterTitle());
    }

    /**
     * Sub menu Search, Choise to search by Title, Author, ISBN
     */
    public void searchMenu() {
        char choice = ' ';
        String answer;

        do {
            printSearchMenu();
            answer = scan.nextLine();
            answer = answer.toUpperCase();
            choice = answer.charAt(0); // Första tecknet i svaret

            switch (choice) {
                case 'A':
                    System.out.println(cob.getBookByTitle(enterTitle()));
                    break;
                case 'B':
                    System.out.println(cob.getBookByISBN(enterISBN()));
                    break;
                case 'C':
                    System.out.println(cob.getBookByAuthor(enterAuthor()));
                    break;
                case 'X':
                    System.out.println("Going back!");
                    break;
                default:
                    System.out.println("Unknown command");
            }

        } while (choice != 'X');
    }

    /**
     * Prints all the books that are stored in the system
     */
    public void printBooks() {
        System.out.println(cob.toString());
    }

    /**
     * Print the sub menu Search
     */
    public void printSearchMenu() {
        System.out.println("---Menu---");
        System.out.println("A Search by Title");
        System.out.println("B Search by ISBN");
        System.out.println("C Search by Authors");
        System.out.println("X Go back");
        System.out.println("----------");
    }

    /**
     * Prints the Main Menu
     */
    public void printMenu() {
        System.out.println("---Menu---");
        System.out.println("A Add new book ");
        System.out.println("B Remove book");
        System.out.println("C Search book");
        System.out.println("D List all books");
        System.out.println("X Exit");
        System.out.println("----------");
    }
}
