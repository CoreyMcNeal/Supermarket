import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cart {
    private Map<Item,Integer> itemsInCart;
    private Scanner reader;
    private Store store;
    
    public Cart(Scanner reader, Store store) {
        this.itemsInCart = new HashMap<>();
        this.reader = reader;
        this.store = store;
    }

    public void addToCart() {
        while (true){
            System.out.println("**Enter blank to finish**");
            System.out.print("Pick: ");
            String itemName = reader.nextLine();
            if (!(validateName(itemName))) {                //loops if item name isn't found in store stock
                continue;
            }

            System.out.print("Amount: ");

            int amount = 0;
            try {
                amount = Integer.valueOf(reader.nextLine());
            } catch (Exception e) {
                System.out.println("Enter an amount please.");
                continue;
            }

            if (!(validateAmount(itemName, amount))) {      // loops back if stock isn't available
                continue;
            }

            grabItem(itemName, amount);
            return;
        }
    }

    public Map<Item,Integer> getItemsInCart() {
        return this.itemsInCart;
    }

    public void setItemsInCart(Map<Item,Integer> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    public void grabItem(String itemName, int amount) {
        Item chosenItem = null;
        for (Item entry: this.store.getAllShelves().keySet()) {
            if (entry.getItemName().equals(itemName)) {
                chosenItem = entry;
            }
        }

        int newStock = this.store.getAllShelves().get(chosenItem) - amount;

        this.store.getAllShelves().put(chosenItem, newStock);
        this.itemsInCart.put(chosenItem, amount);

        System.out.println(this.itemsInCart);
        System.out.println(this.store.getAllShelves());
    }

    public boolean validateName(String name) {
        for (Item entry: this.store.getAllShelves().keySet()) {
            if (entry.getItemName().equals(name)) {
                return true;
            }
        }
        System.out.println("Item not in store.\n");
        return false;
    }

    public boolean validateAmount(String name, int amount) {
        Item product = null;
        for (Item entry: this.store.getAllShelves().keySet()) {
            if (entry.getItemName().equals(name)) {
                product = entry;
            }
        }

        if (this.store.getAllShelves().get(product) < amount) {
            System.out.println("Not enough in stock.\n");
            return false;
        }

        return true;
    }

}
