import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> itemsInCart;


    public Cart() {
        this.itemsInCart = new ArrayList<>();
    }


    public List<Item> getItemsInCart() {
        return this.itemsInCart;
    }

    public void setItemsInCart(List<Item> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

}
