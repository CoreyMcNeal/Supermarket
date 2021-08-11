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
            if (itemName.isBlank()) {
                return;
            } else if (!(validateName(itemName))) {                //loops if item name isn't found in store stock
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

    public void removeFromCart(Item item) {
        this.itemsInCart.put(item, this.itemsInCart.get(item) - 1);
        this.store.getAllShelves().put(item, this.store.getAllShelves().get(item) + 1);
        
        if (this.itemsInCart.get(item) <= 0) {
            this.itemsInCart.remove(item);
        }
    }

    public void printCart() {
        System.out.println("Cart Items: (Total is $" + this.cartTotal() + ")");
        for (Item entry: this.itemsInCart.keySet()) {
            System.out.println(entry.getItemName() + " Qty: " + this.itemsInCart.get(entry) + " $" + (this.itemsInCart.get(entry) * entry.getPrice()));
        }
        System.out.println();
    }

    public int cartTotal() {
        int sum = 0;
        for (Item entry: this.itemsInCart.keySet()) {
            sum += (entry.getPrice() * this.itemsInCart.get(entry));
        }

        return sum;
    }

    public Map<Item,Integer> getItemsInCart() {
        return this.itemsInCart;
    }

    public void setItemsInCart(Map<Item,Integer> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    public void grabItem(String itemName, int amount) {
        Item chosenItem = stringToItem(itemName);

        int newStock = this.store.getAllShelves().get(chosenItem) - amount;

        this.store.getAllShelves().put(chosenItem, newStock);
        this.itemsInCart.put(chosenItem, amount);
        System.out.println("Added " + amount + " " + itemName + " to cart\n" +
                            "...");
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
        Item product = stringToItem(name);

        if (this.store.getAllShelves().get(product) < amount) {
            System.out.println("Not enough in stock.\n");
            return false;
        }

        return true;
    }

    public Item stringToItem(String itemName) {
        Item chosenItem = null;
        while(true){

            for (Item entry: this.store.getAllShelves().keySet()) {
                if (entry.getItemName().equals(itemName)) {
                    chosenItem = entry;
                    return chosenItem;
                }
            }
            
            if (chosenItem == null) {
                System.out.print("Item not on list, try again: ");
                itemName = reader.nextLine();
                continue;
            }
        }
    }
}
