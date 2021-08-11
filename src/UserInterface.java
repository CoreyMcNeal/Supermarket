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
        Cart cart = new Cart(this.reader,store);

        while (true) {
            System.out.println("Department choice: \n" +
                            "1 - Groceries\n" + 
                            "2 - Electronics\n" +
                            "3 - Clothing\n" +
                            "4 - Checkout");
        
            int choice = checkChoice();
            
            if (choice == 1) {
                store.showGroceriesShelf();
                cart.addToCart();
                pause(2000);
                continue;
            } else if (choice == 2) {
                store.showElectronicsShelf();
                cart.addToCart();
                pause(2000);
                continue;
            } else if (choice == 3) {
                store.showClothesShelf();
                cart.addToCart();
                pause(2000);
                continue;
            } else if (choice ==4) {
                customer.checkout(cart);
                
            }
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
                if (!(choice == 1) && !(choice == 2) && !(choice == 3) && !(choice == 4)) {
                    System.out.println("Enter 1, 2, 3, or 4");
                    continue;
                }
                System.out.println();
                return choice;

            } catch (Exception e) {
                System.out.println("Enter 1, 2, 3, or 4");
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
