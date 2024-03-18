// Import the GUI components, Object Libraries, and Action Events and Listeners
import java.util.Objects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Extend JFrame and implement the Action Listener
public class GUI extends JFrame implements ActionListener {

    // Initialize components of the GUI
    JLabel title = new JLabel("Shopping Cart");
    JLabel itemSelectLabel = new JLabel("Select your item:");
    String[] shoppingItems = {"Tissue Box ($3)", "Paper Plate ($2)", "Toilet Paper ($4)", "Plastic Utensils ($2)",
    "Water Bottles ($4)", "Chicken Wings ($7)", "Cereal Box ($5)"};
    JComboBox itemSelectBox = new JComboBox(shoppingItems);
    JLabel discountLabel = new JLabel("Orders of 2 items or more take $1 off each item in the order");
    JLabel itemQuantityLabel = new JLabel("Enter amount for your item order:");
    JTextField itemQuantity = new JTextField(10);
    JButton addBtn = new JButton("Add item order");
    JButton removeBtn = new JButton("Remove item order");
    JButton clearBtn = new JButton("Clear Cart");
    JTextArea cartTextArea = new JTextArea(10,25);
    JScrollPane scrollPane = new JScrollPane(cartTextArea);
    private final ShoppingCart shoppingCart;

    // Constructor method to handle the properties of the GUI Components and add them to the frame
    public GUI () {
        super("Your Shopping Cart");
        title.setFont(new Font("Arial", Font.BOLD, 35));
        itemSelectLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        itemQuantityLabel.setFont(new Font("Arial",Font.PLAIN, 18));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        addBtn.setPreferredSize(new Dimension(225,45));
        removeBtn.setPreferredSize(new Dimension(225,45));
        clearBtn.setPreferredSize(new Dimension(225,45));
        cartTextArea.setLineWrap(true);
        cartTextArea.setWrapStyleWord(true);

        add(title);
        add(itemSelectLabel);
        add(itemSelectBox);
        add(discountLabel);
        add(itemQuantityLabel);
        add(itemQuantity);
        add(addBtn);
        add(removeBtn);
        add(scrollPane);
        add(clearBtn);

        // Add action listeners to the combo box and buttons
        itemSelectBox.addActionListener(this);
        addBtn.addActionListener(this);
        removeBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        shoppingCart = new ShoppingCart();
    }

    // Method that handles all the button events
    public void actionPerformed(ActionEvent e){
        String selectedItem = (String) itemSelectBox.getSelectedItem();
        int itemPrice = 0;
        // If statement that sets the item price depending on which item is selected in the combo box when the addBtn is clicked
        if (e.getSource() == addBtn) {
            if (Objects.equals(selectedItem, "Tissue Box ($3)")) {
                itemPrice = 3;
            }
            else if (Objects.equals(selectedItem, "Toilet Paper ($4)")) {
                itemPrice = 4;
            }
            else if (Objects.equals(selectedItem, "Paper Plate ($2)")) {
                itemPrice = 2;
            }
            else if (Objects.equals(selectedItem, "Plastic Utensils ($2)")) {
                itemPrice = 2;
            }
            else if (Objects.equals(selectedItem, "Water Bottles ($4)")) {
                itemPrice = 4;
            }
            else if (Objects.equals(selectedItem, "Chicken Wings ($7)")) {
                itemPrice = 7;
            }
            else if (Objects.equals(selectedItem, "Cereal Box ($5)")) {
                itemPrice = 5;
            }
            // Creates a new item
            Item newItem = new Item(selectedItem, itemPrice);
            // If statement that tells the user to enter an item amount if the text field is empty
            if (itemQuantity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the item amount for your order");
            }
            else {
                // Otherwise makes the text field input into an integer...
                int quantity = Integer.parseInt(itemQuantity.getText());
                // Creates a new itemOrder...
                ItemOrder newItemOrder = new ItemOrder(newItem, quantity);
                // Adds the itemOrder to the array list and calls the method to update the text area
                shoppingCart.addItemOrder(newItemOrder);
                updateCartTextArea();
            }
        }
        // If statement that removes the first itemOrder from the array list and updates the text area when the removeBtn is clicked
        if (e.getSource() == removeBtn) {
            for (ItemOrder order : shoppingCart.getShoppingCart()) {
                shoppingCart.removeItemOrder(order);
                updateCartTextArea();
                break;
            }
        }
        // If statement that clears the whole shopping cart and updates the text area when the clearBtn is clicked
        if (e.getSource() == clearBtn) {
            shoppingCart.getShoppingCart().clear();
            updateCartTextArea();
        }
    }

    // Method that updates the text area
    private void updateCartTextArea() {
        cartTextArea.setText("Shopping Cart:\n");
        for (ItemOrder order : shoppingCart.getShoppingCart()) {
            // Reformat the name string to remove the price
            String splitItemName = order.getItem().getName().split("\\(")[0];
            // Append the reformatted name, amount, and price for each item order
            cartTextArea.append(splitItemName + " x" + order.getItemNum() + ":  $" + order.OrderCost() + "\n");
        }
        // Append the total price of the shopping cart
        cartTextArea.append("\nTotal Price: $" + shoppingCart.getCartPrice());
    }

    // Method to create the original frame and set it to visible as well as deactivate the resize button
    public static void main(String[] args) {
        final int FRAME_WIDTH = 450;
        final int FRAME_HEIGHT = 700;
        GUI frame = new GUI();
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}