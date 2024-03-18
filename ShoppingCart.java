// Import the ArrayList and List libraries
import java.util.ArrayList;
import java.util.List;

// Create a ShoppingCart class that contains an arraylist for the item orders
public class ShoppingCart {
    private final ArrayList<ItemOrder> shoppingCart;

    // Constructor method that initializes a new shopping cart
    public ShoppingCart () {
        shoppingCart = new ArrayList<>();
    }

    // Method that adds an item order to the shopping cart
    public void addItemOrder(ItemOrder itemOrder) {
        shoppingCart.add(itemOrder);
    }

    // Method that removes an item order from the shopping cart
    public void removeItemOrder(ItemOrder itemOrder) {
        shoppingCart.remove(itemOrder);
    }

    // Method that returns the shopping cart array list
    public List<ItemOrder> getShoppingCart() {
        return shoppingCart;
    }

    // Method that adds all the prices of the item orders and returns the total as an integer
    public int getCartPrice() {
        int cartTotal = 0;
        for (ItemOrder order : shoppingCart) {
            cartTotal += order.OrderCost();
        }
        return cartTotal;
    }
}