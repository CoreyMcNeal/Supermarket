import java.util.Scanner;

public class User {
    private int balance;
    private Scanner reader;

    public User(int balance, Scanner reader) {
        this.balance = balance;
        this.reader = reader;
    }


    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void checkout(Cart cart) {
        while (true) {
            if (this.balance < cart.cartTotal()) {
                System.out.println("Not enough money on store card ($" + this.balance + ")" + "\n" +
                                    "...");
                UserInterface.pause(1500);
                removeItems(cart);
                continue;
            }
            break;
        }

        System.out.println("$" + this.balance + " - $" + cart.cartTotal() + "\n" +
                            "Remaining Balance: " + (this.balance - cart.cartTotal()) + "\n" +
                            "...");
        System.out.println("You Bought: ");
        cart.printCart();
        System.out.println("...");

    }

    public void removeItems(Cart cart) {
        if (this.balance < cart.cartTotal()) {
            cart.printCart();
            System.out.print("Name of item to Remove: ");
            String stringToRemove = reader.nextLine();

            Item itemToRemove = cart.stringToItem(stringToRemove);
            cart.removeFromCart(itemToRemove);
        }
    }

}
