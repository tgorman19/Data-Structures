// Create an Item class that contains a string for the item name and an integer for the item price
public class Item {
    private String itemName;
    private int price;

    // Constructor method that requires a string argument for the item name and an integer argument for the item price
    public Item (String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
    }

    // A get method that returns the item name string
    public String getName() {
        return itemName;
    }

    // A get method that returns the item price integer
    public int getPrice() {
        return price;
    }
}