// Import the GUI components, Necessary Libraries, and Action Events and Listeners
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Extend JFrame and implement the Action Listener
public class DemoPizza extends JFrame implements ActionListener, ItemListener {

    // Initialize components of the GUI and create variables
    JLabel title = new JLabel("Welcome to the Pizza Creator App!");
    JLabel toppingLabel = new JLabel("Enter your toppings into the box one by one: (Max 10 toppings)");
    JLabel quitLabel = new JLabel("(Type QUIT into the box to finishing ordering toppings)");
    JTextField toppingInsert = new JTextField(25);
    JButton toppingBtn = new JButton("Add Topping");
    JLabel deliveryLabel = new JLabel("Would you like your pizza order delivered?");
    JRadioButton yesDelivery = new JRadioButton("Yes");
    JRadioButton noDelivery = new JRadioButton("No");
    JLabel deliveryAddress = new JLabel("If delivery, enter your address here:");
    JTextField addressText = new JTextField(30);
    JTextArea detailsText = new JTextArea(10,25);
    JButton createBtn = new JButton("Create Pizza!");
    JScrollPane scrollPane = new JScrollPane(detailsText);
    String[] toppings = new String[10];
    int toppingPosition = 0;
    Random random;
    int waitTime;
    private Pizza pizza;

    // Constructor method to handle the properties of the GUI Components and add them to the frame
    public DemoPizza(){
        super("Pizza Creator App");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.YELLOW);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        toppingBtn.setPreferredSize(new Dimension(225,45));
        createBtn.setPreferredSize(new Dimension(225,45));
        detailsText.setLineWrap(true);
        detailsText.setWrapStyleWord(true);
        random = new Random();
        waitTime = random.nextInt(31) + 30;

        add(title);
        add(toppingLabel);
        add(quitLabel);
        add(toppingInsert);
        add(toppingBtn);
        add(deliveryLabel);

        ButtonGroup deliveryGroup = new ButtonGroup();
        deliveryGroup.add(yesDelivery);
        deliveryGroup.add(noDelivery);

        add(yesDelivery);
        add(noDelivery);
        add(deliveryAddress);
        add(addressText);
        add(scrollPane);
        add(createBtn);

        // Add action listeners to the combo box and buttons
        toppingBtn.addActionListener(this);
        yesDelivery.addItemListener(this);
        noDelivery.addItemListener(this);
        createBtn.addActionListener(this);
    }

    // Method that handles all the button events
    public void actionPerformed(ActionEvent e){
        // New array for when the user cancels the toppings with QUIT
        String[] quitArray = new String[toppingPosition];
        // If statement that runs if the toppingBtn is clicked
        if (e.getSource() == toppingBtn) {
            // Try and catch blocks to deal with errors
            try {
                // If statement that creates a new array copy of the toppings when QUIT is entered
                if (toppingInsert.getText().equals("QUIT")) {
                    System.arraycopy(toppings,0,quitArray,0,toppingPosition);
                    JOptionPane.showMessageDialog(this, "Toppings Finished");
                }
                // Else statement that adds the topping to the array and changes the array position
                else {
                    toppings[toppingPosition] = toppingInsert.getText();
                    toppingPosition += 1;
                    JOptionPane.showMessageDialog(this, "Topping Added");
                }
                // Resets the topping text box
                toppingInsert.setText("");
            }
            // Catch statement for when the user adds too many toppings
            catch (ArrayIndexOutOfBoundsException exception) {
                JOptionPane.showMessageDialog(this, "Too Many Toppings");
            }
        }
        // If statement that runs if the createBtn is pressed
        if (e.getSource() == createBtn) {
            // If statement that creates different objects depending on whether the pizza is delivery or not
            if (yesDelivery.isSelected()) {
                // Delivery Address
                String address = addressText.getText();
                // If statement that prompts the user to enter an address if the text box was empty
                if (addressText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter Address for Delivery");
                } else {
                    // If statement that determines whether to use the QUIT array or original array
                    if (quitArray != null) {
                        pizza = new DeliveryPizza(toppings, address, toppingPosition);
                        updateDetailTextArea();
                    } else {
                        pizza = new DeliveryPizza(quitArray, address, toppingPosition - 1);
                        updateDetailTextArea();
                    }
                }
                // Else statement that handles when the pizza is not delivery
            } else {
                // Creates pizza objects and determines if the QUIT array or original array is used
                if (quitArray != null) {
                    pizza = new Pizza(toppings, toppingPosition);
                    updateDetailTextArea();
                } else {
                    pizza = new Pizza(quitArray, toppingPosition - 1);
                    updateDetailTextArea();
                }
            }
            // Pop up window that tells the user how long the wait time is when the user clicks the createBtn
            JOptionPane.showMessageDialog(this,"Thank you for the order! " +
                    "Your pizza will be ready in about " + waitTime + " minutes.");
        }
    }

    // Method that handles the radio button events
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItem();
        int select = e.getStateChange();
        if (select == ItemEvent.SELECTED) {
            if (source instanceof JRadioButton) {
                JRadioButton selectedRadioButton = (JRadioButton) source;
                // If statement that determines which radio button is selected
                if (selectedRadioButton == yesDelivery) {
                    // Enables the address text if the order is delivery
                    addressText.enable(true);
                    deliveryAddress.setForeground(Color.BLACK);
                }
                if (selectedRadioButton == noDelivery) {
                    // Disables the address text if the order is not delivery
                    addressText.enable(false);
                    deliveryAddress.setForeground(Color.GRAY);
                }
            }
        }
    }

    // Method that updates the text area using the toString() method
    private void updateDetailTextArea() {
        detailsText.setText(pizza.toString());
    }

    // Method to create the original frame and set it to visible as well as deactivate the resize button
    public static void main(String[] args) {
        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 700;
        DemoPizza frame = new DemoPizza();
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}