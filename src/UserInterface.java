import java.util.Scanner;

public class UserInterface {
    private Scanner reader;

    public UserInterface() {
        this.reader = new Scanner(System.in);
    }

    public void start() {
        Store store = new Store();
        System.out.println("Welcome to Java-Mart!\n" +
                           "---------------------\n" + 
                           "1 - Groceries \n" +
                           "2 - Electronics\n" +
                           "3 - Clothes");
        
        int choice = checkChoice();
        
        if (choice == 1) {
            store.showGroceriesShelf();
        } else if (choice == 2) {
            store.showElectronicsShelf();
        } else if (choice == 3) {
            store.showClothesShelf();
        }
        

    }

    public int checkChoice() {

        while (true) {
            try {
                System.out.print("Choice: ");
                int choice = Integer.valueOf(reader.nextLine());
                if (!(choice == 1) && !(choice == 2) && !(choice ==3)) {
                    System.out.println("Enter 1, 2, or 3");
                    continue;
                }
                System.out.println();
                return choice;

            } catch (Exception e) {
                System.out.println("Enter 1, 2, or 3");
                continue;
            }
        }
    }
}
