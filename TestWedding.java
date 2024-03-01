//Tate Gorman and Jason Shackley

//Import the GUI components and Action/Item Events and Listeners
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Extend JFrame and implement the listeners
public class TestWedding extends JFrame implements ActionListener, ItemListener {

    // Initialize components of the GUI
    JLabel title = new JLabel("Welcome to the Wedding Card Creator!");
    JLabel bFirstNameLabel = new JLabel ("Enter the Bride's First Name:");
    JTextField bFirstNameField = new JTextField(12);
    JLabel bLastNameLabel = new JLabel ("Enter the Bride's Last Name:");
    JTextField bLastNameField = new JTextField(12);
    JLabel gFirstNameLabel = new JLabel ("Enter the Groom's First Name:");
    JTextField gFirstNameField = new JTextField(12);
    JLabel gLastNameLabel = new JLabel ("Enter the Groom's Last Name:");
    JTextField gLastNameField = new JTextField(12);
    JLabel dateLabel = new JLabel ("Enter the Date of the Wedding (YYYY-MM-DD):");
    JTextField dateField = new JTextField(15);
    JLabel locationLabel = new JLabel ("Enter the Wedding Location:");
    JTextField locationField = new JTextField(18);
    JButton createBtn = new JButton("Create!");
    String rsvpResponse = "";

    // Constructor method to handle the properties of the GUI Components and add them to the frame
    public TestWedding() {
        super("Wedding Card Creator");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.CYAN);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
        createBtn.setPreferredSize(new Dimension(400,50));

        add(title);
        add(bFirstNameLabel);
        add(bFirstNameField);
        add(bLastNameLabel);
        add(bLastNameField);
        add(gFirstNameLabel);
        add(gFirstNameField);
        add(gLastNameLabel);
        add(gLastNameField);
        add(dateLabel);
        add(dateField);
        add(locationLabel);
        add(locationField);
        add(createBtn);

        // Add action listener to the create button
        createBtn.addActionListener(this);
    }

    // Method that is called when the create button is clicked, creates a new frame and initializes all the aspects of the new GUI
    private void createWeddingCard() {
        JFrame weddingCard = new JFrame("Wedding Card");
        weddingCard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        weddingCard.setSize(650,350);
        weddingCard.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
        weddingCard.getContentPane().setBackground(Color.PINK);
        String brideFirstName = bFirstNameField.getText();
        String brideLastName = bLastNameField.getText();
        String groomFirstName = gFirstNameField.getText();
        String groomLastName = gLastNameField.getText();
        Person bride = new Person(brideFirstName, brideLastName);
        Person groom = new Person(groomFirstName, groomLastName);
        Couple couple = new Couple(bride, groom);
        String userDateInput = dateField.getText();
        LocalDate weddingDate = LocalDate.parse(userDateInput);
        String location = locationField.getText();
        Wedding wedding = new Wedding(location, couple, weddingDate);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formatDate = wedding.getDate().format(format);

        JLabel cardTitle = new JLabel(wedding.getCouple().getBride().getFirst() + " "
                + wedding.getCouple().getBride().getLast() + " and " + wedding.getCouple().getGroom().getFirst() + " " +
                wedding.getCouple().getGroom().getLast() + " are getting married!");
        cardTitle.setFont(new Font("Times New Roman", Font.ITALIC, 20));

        JLabel dateLocationLabel = new JLabel("Join us on " + formatDate + " at " + location +
                " to celebrate this wonderful time!");
        dateLocationLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));

        JLabel rsvpLabel = new JLabel("Please RSVP and we hope you can attend!");
        rsvpLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));

        JRadioButton yesRSVP = new JRadioButton("I'll be there!");
        JRadioButton noRSVP = new JRadioButton("So sorry! Can't make it!");

        JButton sendBtn = new JButton("Send Response");

        // Adds all components to the frame
        weddingCard.add(cardTitle);
        weddingCard.add(dateLocationLabel);
        weddingCard.add(rsvpLabel);
        weddingCard.add(yesRSVP);
        weddingCard.add(noRSVP);
        weddingCard.add(sendBtn);

        // Creates a button group for the RSVP buttons
        ButtonGroup rsvpButtons = new ButtonGroup();
        rsvpButtons.add(yesRSVP);
        rsvpButtons.add(noRSVP);

        // Add item listeners to the RSVP buttons
        yesRSVP.addItemListener(this);
        noRSVP.addItemListener(this);

        // Adds an action listener to the send response button and displays a message window depending on the RSVP answer
        sendBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, rsvpResponse);
                weddingCard.dispose();
            }
        });

        // Set the frame to visible and deactivate the resize button
        weddingCard.setResizable(false);
        weddingCard.setVisible(true);
    }

    // Method to handle the create button which calls the method that creates the wedding card
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == createBtn) {
            createWeddingCard();
        }
    }

    // Method that changes the RSVP response depending on which radio button is selected
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItem();
        int select = e.getStateChange();
        if (select == ItemEvent.SELECTED) {
            JRadioButton selectedRadioButton = (JRadioButton) source;
            if (selectedRadioButton.getText().equals("I'll be there!")) {
                rsvpResponse = "Great! We can't wait to see you there!";
            }
            else if (selectedRadioButton.getText().equals("So sorry! Can't make it!")) {
                rsvpResponse = "No worries! We hope you celebrate from afar!";
            }
        }
    }

    // Method to create the original frame and set it to visible as well as deactivate the resize button
    public static void main(String[] args) {
        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 600;
        TestWedding frame = new TestWedding();
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}