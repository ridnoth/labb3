
import java.util.Scanner;

public class Menu {

    private Scanner scan;
    CollectionOfBooks cob = new CollectionOfBooks();

    public Menu() {
        scan = new Scanner(System.in);
    }

    // Huvudloopen för menyn
    public void run() {
        char choice = ' ';
        String answer;

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
        System.out.println("Enter another author? (Y/N): ");
        String answer = scan.nextLine();
        do {
            if (answer.toUpperCase().equals("Y")) {
                book.addAuthor(enterAuthor());
            }
        } while (answer.toUpperCase().equals("Y"));
    }

    // Definierar ett "uppdrag"
    public void createBook() {
        Book book = new Book(enterISBN(), enterTitle(), enterEdition(), enterPrice(), enterAuthor());
        cob.addBook(book);
        enterMoreAuthors(book);
    }

    // Definierar ett annat "uppdrag"
    public void deleteBook() {
        System.out.println("");
    }

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
                    cob.getBookByTitle(enterTitle());
                    break;
                case 'B':
                    cob.getBookByISBN(enterISBN());
                    break;
                case 'C':
                    cob.getBookByAuthor(enterAuthor());
                    break;
                case 'X':
                    System.out.println("Going back!");
                    break;
                default:
                    System.out.println("Unknown command");
            }

        } while (choice != 'X');
    }

    public void printBooks() {
        System.out.println("Doing that...");
    }

    public void printSearchMenu() {
        System.out.println("---Menu---");
        System.out.println("A Search by Title");
        System.out.println("B Search by ISBN");
        System.out.println("C Search by Authors");
        System.out.println("X Go back");
        System.out.println("----------");
    }

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
