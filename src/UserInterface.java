import java.util.Scanner;

public class UserInterface {
    private Scanner reader;

    public UserInterface() {
        this.reader = new Scanner(System.in);
    }

    public void start() {
        Store store = new Store();
        System.out.println("Welcome to Java-Mart!\n" +
                            "...");
        pause(1000);

        User customer = loadCard();
        
        System.out.println("Department choice: \n" +
                            "1 - Groceries\n" + 
                            "2 - Electronics\n" +
                            "3 - Clothing");
        
        int choice = checkChoice();
        
        if (choice == 1) {
            store.showGroceriesShelf();
        } else if (choice == 2) {
            store.showElectronicsShelf();
        } else if (choice == 3) {
            store.showClothesShelf();
        }
        

    }

    public User loadCard() {
        System.out.println("How much would you like to load on your store card?");

        int amount;
        while (true) {
            try {
                System.out.print(": $");
                amount = Integer.valueOf(reader.nextLine());
                System.out.println("$" + amount + " has been loaded onto your card.\n" +
                                    "...");
                pause(1500);
                break;
            } catch (Exception e) {
                System.out.println("Please enter whole dollar amount.");
                continue;
            }
        }

        return new User(amount);
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

    public static void pause(int milliseconds) {               // Pause method to let the program have some flow
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
