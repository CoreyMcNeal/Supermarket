import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Item> electronicsShelf;
    private List<Item> groceriesShelf;
    private List<Item> clothesShelf;

    public Store() {
        this.electronicsShelf = new ArrayList<>();
        this.groceriesShelf = new ArrayList<>();
        this.clothesShelf = new ArrayList<>();
    }

    public List<Item> getElectronicsShelf() {
        return this.electronicsShelf;
    }

    public void setElectronicsShelf(List<Item> electronicsShelf) {
        this.electronicsShelf = electronicsShelf;
    }

    public List<Item> getGroceriesShelf() {
        return this.groceriesShelf;
    }

    public void setGroceriesShelf(List<Item> groceriesShelf) {
        this.groceriesShelf = groceriesShelf;
    }

    public List<Item> getClothesShelf() {
        return this.clothesShelf;
    }

    public void setClothesShelf(List<Item> clothesShelf) {
        this.clothesShelf = clothesShelf;
    }

}
