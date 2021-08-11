import java.util.HashMap;
import java.util.Map;

public class Store {

    private Map<Item, Integer> electronicsShelf;
    private Map<Item, Integer> groceriesShelf;
    private Map<Item, Integer> clothesShelf;
    private Map<Item, Integer> allShelves;

    public Store() {
        this.electronicsShelf = new HashMap<>();
        this.groceriesShelf = new HashMap<>();
        this.clothesShelf = new HashMap<>();
        this.allShelves = new HashMap<>();
        generateClothes();
        generateElectronics();
        generateGroceries();
        generateAll();
    }

    public void showGroceriesShelf() {
        for (Item entry: this.groceriesShelf.keySet()) {
            System.out.println(entry.getItemName() + ": " +
             this.allShelves.get(entry) + spacer(entry) + "$" + entry.getPrice());
        }
        System.out.println();
    }

    public void showElectronicsShelf() {
        for (Item entry: this.electronicsShelf.keySet()) {
            System.out.println(entry.getItemName() + ": " + 
            this.allShelves.get(entry) + spacer(entry) + "$" + entry.getPrice());
        }
        System.out.println();
    }

    public void showClothesShelf() {
        for (Item entry: this.clothesShelf.keySet()) {
            System.out.println(entry.getItemName() + ": " + 
            this.allShelves.get(entry) + spacer(entry) + "$" + entry.getPrice());
        }
        System.out.println();
    }

    public String spacer(Item item) {
        int intSpace = 18 - item.getItemName().length();

        StringBuilder space = new StringBuilder();
        for (int i = 0; i < intSpace; i++) {
            space.append(" ");
        }

        return space.toString();
    }


    public Map<Item,Integer> getElectronicsShelf() {
        return this.electronicsShelf;
    }

    public void setElectronicsShelf(Map<Item,Integer> electronicsShelf) {
        this.electronicsShelf = electronicsShelf;
    }

    public Map<Item,Integer> getGroceriesShelf() {
        return this.groceriesShelf;
    }

    public void setGroceriesShelf(Map<Item,Integer> groceriesShelf) {
        this.groceriesShelf = groceriesShelf;
    }

    public Map<Item,Integer> getClothesShelf() {
        return this.clothesShelf;
    }

    public void setClothesShelf(Map<Item,Integer> clothesShelf) {
        this.clothesShelf = clothesShelf;
    }


    public Map<Item,Integer> getAllShelves() {
        return this.allShelves;
    }

    public void setAllShelves(Map<Item,Integer> allShelves) {
        this.allShelves = allShelves;
    }



    public void generateElectronics() {
        this.electronicsShelf.put(new Item("Samsung TV", 500), 3);
        this.electronicsShelf.put(new Item("Xbox", 300), 2);
        this.electronicsShelf.put(new Item("Playstation", 300), 2);
        this.electronicsShelf.put(new Item("iPhone", 500), 1);
    }

    public void generateGroceries() {
        this.groceriesShelf.put(new Item("Milk", 2), 4);
        this.groceriesShelf.put(new Item("Bread", 2), 5);
        this.groceriesShelf.put(new Item("Orange Juice", 1), 3);
        this.groceriesShelf.put(new Item("Chips", 1), 3);
    }

    public void generateClothes() {
        this.clothesShelf.put(new Item("T Shirt", 6), 2);
        this.clothesShelf.put(new Item("Socks", 3), 2);
        this.clothesShelf.put(new Item("Pants", 5), 2);
        this.clothesShelf.put(new Item("Hat", 3), 2);
    }

    public void generateAll() {
        this.allShelves.putAll(this.clothesShelf);
        this.allShelves.putAll(this.electronicsShelf);
        this.allShelves.putAll(this.groceriesShelf);
    }

}
