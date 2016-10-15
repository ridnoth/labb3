/** Fˆr inl‰sning vid val av meny-alternativ anv‰nder jag
 *	genomgÂende scan.nextLine(). N‰r jag vill se ett 
 *	enskilt tecken anv‰nder jag charAt(int index) frÂn 
 *	String-klassen.
 */

import java.util.Scanner;

public class Menu {

	private Scanner scan;

    public Menu() {
    	scan = new Scanner(System.in);
    }
    
    // Huvudloopen fˆr menyn
    public void run() {
    	char choice = ' ';
    	String answer;
    	
    	do {
    		printMenu();
    		answer = scan.nextLine();
    		answer = answer.toUpperCase();
    		choice = answer.charAt(0); // Fˆrsta tecknet i svaret
    		
    		switch(choice) {
    			case 'A':	doThis(); break;
    			case 'B':	doThat(); break;
    			case 'X':	System.out.println("Bye, bye!"); break;
    			default: 	System.out.println("Unknown command");
    		}
    		
    	} while(choice != 'X');
    }
    
    // Definierar ett "uppdrag"
    public void doThis() {
    	System.out.println("Doing this...");
    }
    
    // Definierar ett annat "uppdrag"
    public void doThat() {
    	System.out.println("Doing that...");
    }
    
    public void printMenu() {
    	System.out.println("---Menu---");
    	System.out.println("A Do This");
    	System.out.println("B Do That");
    	System.out.println("X Exit");
    	System.out.println("----------");
    }
    
    public static void main(String[] args) {
    	Menu menu = new Menu();
    	menu.run();
    }
}