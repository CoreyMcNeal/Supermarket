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
            System.out.print("Pick: ");
            String itemName = reader.nextLine();
            if (!(validateName(itemName))) {
                continue;
            }

            System.out.print("Amount: ");
            try {
                int amount = Integer.valueOf(reader.nextLine());
            } catch (Exception e) {
                System.out.println("Enter an amount please.");
                continue;
            }


        }
    }

    public Map<Item,Integer> getItemsInCart() {
        return this.itemsInCart;
    }

    public void setItemsInCart(Map<Item,Integer> itemsInCart) {
        this.itemsInCart = itemsInCart;
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
        return true; //temp
    }

}
