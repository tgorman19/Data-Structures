// Create a DeliveryPizza class that inherits from the Pizza Class and contains an integer for the delivery fee
// And a string for the delivery address
public class DeliveryPizza extends Pizza {
    public int deliveryFee;
    public String deliveryAddress;

    // Constructor method that requires an array argument for toppings, string for the address, and an integer argument for topping number
    public DeliveryPizza (String[] toppings, String deliveryAddress, int toppingNum) {
        // Inherits from Pizza constructor
        super(toppings, toppingNum);
        this.deliveryAddress = deliveryAddress;

        // Sets delivery fee depending on the price of the pizza
        if (getPrice() > 18) {
            this.deliveryFee = 3;
        }
        else if (getPrice() <= 18) {
            this.deliveryFee = 5;
        }
    }

    // Method that overrides the other toString() method, this time including delivery information and a total price
    @Override
    public String toString() {
        return super.toString() + "\n\nDeliver to: " + deliveryAddress + "\nDelivery Fee: $" + deliveryFee
                + "\n\nTotal: $" + (getPrice() + deliveryFee);
    }
}