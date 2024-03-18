// Create a Pizza class that contains an array for the toppings and an integer for the pizza price
public class Pizza {
    public String[] toppings;
    public int price;

    // Constructor method that requires an array argument for toppings and an integer argument for the pizza price
    public Pizza (String[] toppings, int toppingNum) {
        this.toppings = new String[toppingNum];
        System.arraycopy(toppings, 0, this.toppings, 0, toppingNum);

        // Sets the pizza price depending on the number of toppings
        price = 14 + (2 * toppingNum);
    }

    // A get method that returns the pizza price integer
    public int getPrice() {
        return price;
    }

    // Method that takes the array of toppings and price and returns a string description
    public String toString() {
        return "Pizza with: " + String.join(", ", toppings) + "\nPrice: $" + price;
    }
}