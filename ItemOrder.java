// Create an ItemOrder class that contains an item object and an integer for the item amount
public class ItemOrder {
    private Item item;
    private int itemNum;

    // Constructor method that requires an item argument for the item and an integer argument for the item amount
    public ItemOrder (Item item, int itemNum){
        this.item = item;
        this.itemNum = itemNum;
    }

    // Method that calculates the price of one item order and gives a discount if the items are ordered in bulk
    public int OrderCost () {
        if (itemNum > 1) {
            return ((item.getPrice() - 1) * itemNum);
        }
        else return item.getPrice();
    }

    // A get method that returns the item object
    public Item getItem() {
        return item;
    }

    // A get method that returns the item amount integer
    public int getItemNum() {
        return itemNum;
    }
}