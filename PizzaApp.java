// Import the GUI components and Action/Item Events and Listeners
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Extend JFrame and implement the listeners
public class PizzaApp extends JFrame implements ItemListener, ActionListener {

    // Set the prices to zero and initialize all the components of the GUI
    double sizePrice = 0.00;
    double toppingPrice = 0.00;
    double mealPrice = 0.00;
    byte toppingNum = 0;
    JLabel title = new JLabel("Welcome to the BigY Pizza Ordering App!");
    JLabel label = new JLabel("Select A Pizza Size:");
    JRadioButton smallSize = new JRadioButton("Small", false);
    JRadioButton mediumSize = new JRadioButton("Medium", false);
    JRadioButton largeSize = new JRadioButton("Large", false);
    JRadioButton superSize = new JRadioButton("Super", false);
    JLabel notes = new JLabel("Each topping is $0.50! Order 3 toppings for $0.25 off! Extra cheese is free of charge!");
    JLabel topping = new JLabel("Select Your Toppings:");
    JCheckBox toppingXCheese = new JCheckBox("Extra Cheese", false);
    JCheckBox toppingPepperoni = new JCheckBox("Pepperoni", false);
    JCheckBox toppingSausage = new JCheckBox("Sausage", false);
    JCheckBox toppingPine = new JCheckBox("Pineapple", false);
    JLabel meal = new JLabel("Make your order a meal? A meal adds one drink and one side to your order.");
    JRadioButton yesMeal = new JRadioButton("Yes", false);
    JRadioButton noMeal = new JRadioButton("No", false);
    JLabel side = new JLabel("Select Your Side:");
    JRadioButton gKnots = new JRadioButton("Garlic Knots", false);
    JRadioButton wings = new JRadioButton("Chicken Wings", false);
    JRadioButton fries = new JRadioButton("Fries", false);
    JRadioButton oRings = new JRadioButton("Onion Rings", false);
    JLabel drink = new JLabel("Select Your Drink:");
    JRadioButton water = new JRadioButton("Water", false);
    JRadioButton cola = new JRadioButton("Cola", false);
    JRadioButton lemonade = new JRadioButton("Lemonade", false);
    JRadioButton iceTea = new JRadioButton("Iced Tea", false);
    JButton submitBtn = new JButton("Submit Order");
    JTextField priceField = new JTextField("Price");

    // Method to disable all side and drink buttons
    private void disableSideAndDrinkButtons() {
        gKnots.setEnabled(false);
        wings.setEnabled(false);
        fries.setEnabled(false);
        oRings.setEnabled(false);
        water.setEnabled(false);
        cola.setEnabled(false);
        lemonade.setEnabled(false);
        iceTea.setEnabled(false);
    }

    // Method to enable all side and drink buttons
    private void enableSideAndDrinkButtons() {
        gKnots.setEnabled(true);
        wings.setEnabled(true);
        fries.setEnabled(true);
        oRings.setEnabled(true);
        water.setEnabled(true);
        cola.setEnabled(true);
        lemonade.setEnabled(true);
        iceTea.setEnabled(true);
    }

    // Method to update the price depending on the amount of toppings that are selected after the topping checkboxes are checked
    private void updateToppingPrice() {
        // If the user selects 4 toppings a message window pops up telling them they selected too many toppings
        if (toppingNum >= 4) {
            JOptionPane.showMessageDialog(null, "Too many Toppings");
        }
        // If the number of toppings is 3 and extra cheese is selected the topping price is $1 because extra cheese has no cost
        else if (toppingNum == 3 && toppingXCheese.isSelected()) {
            toppingPrice = 1.00;
        }
        // If the number of toppings is 3 and extra cheese is not selected the topping price is $1.25 because of the deal
        else if (toppingNum == 3) {
            toppingPrice = 1.25;
        }
        // If the number of toppings is 2 and extra cheese is selected the topping price is $0.50
        else if (toppingNum == 2 && toppingXCheese.isSelected()) {
            toppingPrice = 0.50;
        }
        // If the number of toppings is 2 and extra cheese is not selected the topping price is $1.00
        else if (toppingNum == 2) {
            toppingPrice = 1.00;
        }
        // If the only topping is extra cheese the topping price is $0.50
        else if (toppingNum == 1 && toppingXCheese.isSelected()) {
            toppingPrice = 0.00;
        }
        // If the number of toppings is 1 and extra cheese is not selected the topping price is $0.50
        else if (toppingNum == 1) {
            toppingPrice = 0.50;
        }
    }

    // Method to handle the properties of the GUI components
    public PizzaApp() {
        // Name the frame "BigY Pizza Application"
        super("BigY Pizza Application");
        // Activate the close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Make the background light gray
        getContentPane().setBackground(Color.LIGHT_GRAY);
        // Set the layout to FlowLayout
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
        // Set the font and color of all the labels and buttons
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(Color.BLUE);
        label.setFont(new Font("Dialog", Font.BOLD, 14));
        label.setForeground(Color.BLACK);
        notes.setFont(new Font("Dialog", Font.BOLD, 12));
        notes.setForeground(Color.red);
        topping.setFont(new Font("Dialog", Font.BOLD, 13));
        topping.setForeground(Color.BLACK);
        meal.setFont(new Font("Dialog", Font.BOLD, 12));
        meal.setForeground(Color.red);
        side.setFont(new Font("Dialog", Font.BOLD, 12));
        side.setForeground(Color.GRAY);
        drink.setFont(new Font("Dialog", Font.BOLD, 12));
        drink.setForeground(Color.GRAY);
        submitBtn.setPreferredSize(new Dimension(550, 30));
        priceField.setPreferredSize(new Dimension(200, 50));
        priceField.setHorizontalAlignment(JTextField.CENTER);

        // Add item and action listeners to the buttons
        smallSize.addItemListener(this);
        mediumSize.addItemListener(this);
        largeSize.addItemListener(this);
        superSize.addItemListener(this);
        toppingXCheese.addItemListener(this);
        toppingPepperoni.addItemListener(this);
        toppingSausage.addItemListener(this);
        toppingPine.addItemListener(this);
        yesMeal.addItemListener(this);
        noMeal.addItemListener(this);
        submitBtn.addActionListener(this);

        // Make the size buttons a button group
        ButtonGroup pizzaSize = new ButtonGroup();
        pizzaSize.add(smallSize);
        pizzaSize.add(mediumSize);
        pizzaSize.add(largeSize);
        pizzaSize.add(superSize);

        // Make the meal buttons a button group
        ButtonGroup mealGroup = new ButtonGroup();
        mealGroup.add(yesMeal);
        mealGroup.add(noMeal);

        // Make the side buttons a button group
        ButtonGroup sideGroup = new ButtonGroup();
        sideGroup.add(gKnots);
        sideGroup.add(wings);
        sideGroup.add(fries);
        sideGroup.add(oRings);

        // Make the drink buttons a button group
        ButtonGroup drinkGroup = new ButtonGroup();
        drinkGroup.add(water);
        drinkGroup.add(cola);
        drinkGroup.add(lemonade);
        drinkGroup.add(iceTea);

        // Call the method to disable all side and drink buttons so the user cannot click them until the yesMeal button is clicked
        disableSideAndDrinkButtons();
        // Add all the components onto the frame
        add(title);
        add(label);
        add(smallSize);
        add(mediumSize);
        add(largeSize);
        add(superSize);
        add(notes);
        add(topping);
        add(toppingXCheese);
        add(toppingPepperoni);
        add(toppingSausage);
        add(toppingPine);
        add(meal);
        add(yesMeal);
        add(noMeal);
        add(side);
        add(gKnots);
        add(wings);
        add(fries);
        add(oRings);
        add(drink);
        add(water);
        add(cola);
        add(lemonade);
        add(iceTea);
        add(submitBtn);
        add(priceField);
    }

    // Override allows me to override elements declared above
    @Override
    // Method that handles when the radio buttons and checkboxes are used
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItem();
        int select = e.getStateChange();
        if (select == ItemEvent.SELECTED) {
            // If statement that runs if the radio buttons are used
            if (source instanceof JRadioButton) {
                JRadioButton selectedRadioButton = (JRadioButton) source;
                // If the small button is clicked set the size price to $5
                if (selectedRadioButton == smallSize) {
                    sizePrice = 5.00;
                }
                // If the medium button is clicked set the size price to $10
                else if (selectedRadioButton == mediumSize) {
                    sizePrice = 10.00;
                }
                // If the large button is clicked set the size price to $15
                else if (selectedRadioButton == largeSize) {
                    sizePrice = 15.00;
                }
                // If the super button is clicked set the size price to $20
                else if (selectedRadioButton == superSize) {
                    sizePrice = 20.00;
                }
                // If the yesMeal button is clicked set the meal price to $5 and enable the side and drink buttons
                else if (selectedRadioButton == yesMeal) {
                    mealPrice = 5.00;
                    enableSideAndDrinkButtons();
                    side.setForeground(Color.BLACK);
                    drink.setForeground(Color.BLACK);
                }
                // If the noMeal button is clicked set the meal price to $0 and disable the side and drink buttons
                else if (selectedRadioButton == noMeal) {
                    mealPrice = 0.00;
                    disableSideAndDrinkButtons();
                    side.setForeground(Color.GRAY);
                    drink.setForeground(Color.GRAY);
                }
            }

            // If statement that runs if the checkboxes are used
            if (source instanceof JCheckBox) {
                JCheckBox selectedCheckBox = (JCheckBox) source;
                // If statement that runs when the extra cheese checkbox is checked
                if (selectedCheckBox == toppingXCheese) {
                    // Adds 1 to the topping number
                    toppingNum += 1;
                }
                // If statement that runs when the other 3 topping checkboxes are checked
                else if (selectedCheckBox == toppingPepperoni || selectedCheckBox == toppingSausage
                        || selectedCheckBox == toppingPine) {
                    // Adds 1 to the topping number and $0.50 to the topping price
                    toppingNum += 1;
                    toppingPrice += 0.50;
                }
                // Call the method to determine the price of toppings based on how many and which ones are checked
                updateToppingPrice();
            }
        }

        // Else statement that runs if the checkboxes are deselected
        else {
            if (source instanceof JCheckBox) {
                JCheckBox deselectedCheckBox = (JCheckBox) source;
                // If statement that runs when the extra cheese checkbox is deselected
                if (deselectedCheckBox == toppingXCheese) {
                    // Remove 1 from the topping number
                    toppingNum -= 1;
                }
                // Else statement that runs when any of the other topping checkboxes are deselected
                else {
                    // Remove 1 from the topping number and $0.50 from the topping price
                    toppingNum -= 1;
                    toppingPrice -= 0.50;
                }
                // Call the method to determine the price of toppings based on how many and which ones are checked
                updateToppingPrice();
            }
        }
    }

    // Method that handles when the submit order button is clicked
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == submitBtn) {
            // Create a total price double
            double total = sizePrice + toppingPrice + mealPrice;
            // Set the text of the text field to the total and format the variable to display two decimals
            priceField.setText("Total: $" + String.format("%.2f",total));
            // When the submit order button is clicked a message window pops up to display the cost breakdown
            JOptionPane.showMessageDialog(null,"Order received.\nSize: $" +
                    String.format("%.2f", sizePrice) +
                    "\nToppings: $" + String.format("%.2f", toppingPrice) +
                    "\nMeal: $" + String.format("%.2f",mealPrice) +"\nYour order was $" + String.format("%.2f",total));
        }
    }

    // Method to create the frame and set it to visible as well as deactivate the resize button
    public static void main(String[] args) {
        final int FRAME_WIDTH = 600;
        final int FRAME_HEIGHT = 675;
        PizzaApp frame = new PizzaApp();
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}