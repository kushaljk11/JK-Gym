import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * A graphical user interface for a gym management system.
 * This class provides functionality for managing gym members including regular and premium members.
 * Features include adding members, activating/deactivating memberships, upgrading plans,
 * marking attendance, and saving member data to files.
 *
 * @author Kushal jamarlkattel
 * @version 1.0
 */
public class gymGUI {  

    /**
     * The main entry point for the gym management system GUI.
     * Creates and displays the main application window with all components and functionality.
     * 
     * Features include:
     * Member registration (Regular and Premium)
     * Membership activation/deactivation
     * Plan upgrades
     * Attendance tracking
     * Payment processing
     * Member data persistence
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

        ArrayList<GymMember> members = new ArrayList<>();

        /**  setting font for heading */
        
        //for labels and others
        Font font2 = new Font("Arial-SemiBold", Font.BOLD, 16);

        /**
         * Main frame for the application
         */
        JFrame frame = new JFrame("Gym Management System");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setBackground(Color.BLACK);

        //for image icon
        ImageIcon icon = new ImageIcon("8326767-02.png");
        frame.setIconImage(icon.getImage());

        // Set the default close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Panel for member input fields*[*]
         */
        JPanel panel = new JPanel();
        panel.setBounds(30, 80, 700, 550);
        // panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createTitledBorder(""));
        frame.add(panel);


        //pannel for button
        JPanel pannel2 = new JPanel();
        pannel2.setBounds(30, 670, 1500, 150);
        pannel2.setLayout(new GridLayout(2, 1, 5, 95));
        frame.add(pannel2);

        //setting the picture of gym
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("8326767-02.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        imagePanel.setBounds(490, 5, 200, 200);
        panel.add(imagePanel);

        //font size for main font
        Font font = new Font("Arial", Font.BOLD, 25);
        
        // heading
        JLabel head = new JLabel("Gym Management System");
        head.setBounds(660, 10, 400, 50);
        head.setForeground(new Color(255, 70, 0));
        head.setFont(font);
        // head.setFont(font1);
        frame.add(head);

        //name
        JLabel name = new JLabel("Name: ");
        name.setBounds(20, 10, 100, 30);
        name.setFont(font2);
        panel.add(name);

        //name placeholder
        JTextField namefield = new JTextField();
        namefield.setBounds(80, 15, 150, 30);
        panel.add(namefield);

        //id
        JLabel id = new JLabel("ID: ");
        id.setBounds(20, 50, 100, 30);
        id.setFont(font2);
        panel.add(id);

        //id placeholder
        JTextField idfield = new JTextField();
        idfield.setBounds(50, 55, 150, 30);
        panel.add(idfield);

        //location
        JLabel location = new JLabel("Location: ");
        location.setBounds(20, 95, 100, 30);
        location.setFont(font2);
        panel.add(location);

        //location placeholder
        JTextField locationfield = new JTextField();
        locationfield.setBounds(100, 100, 150, 30);
        panel.add(locationfield);

        //phone
        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(20, 140, 100, 30);
        phone.setFont(font2);
        panel.add(phone);

        //phone placeholder
        JTextField phonefield = new JTextField();
        phonefield.setBounds(90, 145, 150, 30);
        panel.add(phonefield);

        //email
        JLabel email = new JLabel("Email: ");
        email.setBounds(20, 185, 100, 30);
        email.setFont(font2);
        panel.add(email);

        //email placeholder
        JTextField emailfield = new JTextField();
        emailfield.setBounds(90, 190, 150, 30);
        panel.add(emailfield);

        //DOB
        // JLabel dob = new JLabel("DOB: ");
        // dob.setBounds(20, 230, 100, 30);
        // dob.setFont(font2);
        // panel.add(dob);

        // //DOB placeholder
        // JTextField dobfield = new JTextField();
        // dobfield.setBounds(90, 235, 150, 30);
        // panel.add(dobfield);

        JLabel label = new JLabel("Date of Birth:");
        label.setBounds(20, 230, 140, 30);
        label.setFont(font2);
        
        JComboBox<Integer> dayCombo = new JComboBox<>();
        dayCombo.setBounds(130, 235, 50, 25);
        
        JComboBox<String> monthCombo = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        monthCombo.setBounds(180, 235, 100, 25);
        
        JComboBox<Integer> yearCombo = new JComboBox<>();
        yearCombo.setBounds(300, 235, 70, 25);

        for (int i = 1; i <= 31; i++) {
            dayCombo.addItem(i);
        }
        
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int i = currentYear; i >= 1998; i--) {
            yearCombo.addItem(i);
        }

        panel.add(label);
        panel.add(dayCombo);
        panel.add(monthCombo);
        panel.add(yearCombo);

        //membership
        // JLabel membership = new JLabel("Membership start date: ");
        // membership.setBounds(20, 275, 200, 30);
        // membership.setFont(font2);
        // panel.add(membership);

        // //membership field
        // JTextField membershipfield = new JTextField();
        // membershipfield.setBounds(210, 280, 150, 30);
        // panel.add(membershipfield);

        JLabel membership = new JLabel("Membership Start Date:");
        membership.setBounds(20, 275, 200, 30);
        membership.setFont(font2);
    
        JComboBox<Integer> dayCombo1 = new JComboBox<>();
        dayCombo1.setBounds(210, 280, 50, 25);
        
        JComboBox<String> monthCombo1 = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        monthCombo1.setBounds(260, 280, 100, 25);
        
        JComboBox<Integer> yearCombo1 = new JComboBox<>();
        yearCombo1.setBounds(360, 280, 70, 25);

        for (int i = 1; i <= 31; i++) {
            dayCombo1.addItem(i);
        }
        
        int currentYear1 = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int i = currentYear1; i >= 1998; i--) {
            yearCombo1.addItem(i);
        }

        panel.add(membership);
        panel.add(dayCombo1);
        panel.add(monthCombo1);
        panel.add(yearCombo1);


        //referral source
        JLabel source = new JLabel("Referral Source:");
        source.setBounds(20, 320, 200, 30);
        source.setFont(font2);
        panel.add(source);

        //referral field
        JTextField sourcefield = new JTextField();
        sourcefield.setBounds(160, 325, 150, 30);
        panel.add(sourcefield);

 
         // Create and set the premium plan charge field
         JLabel premiumPlanChargeLabel = new JLabel("Premium Plan Charge:");
         premiumPlanChargeLabel.setBounds(340, 370, 180, 25);
         premiumPlanChargeLabel.setFont(font2);
         JTextField premiumPlanPriceField = new JTextField("50000");
         premiumPlanPriceField.setBounds(520, 370, 100, 25);
         premiumPlanPriceField.setEditable(false);
         panel.add(premiumPlanChargeLabel);
         panel.add(premiumPlanPriceField);

 

        //Paid amount
        JLabel paid = new JLabel("Paid Amount: ");
        paid.setBounds(20, 365, 200, 30);
        paid.setFont(font2);
        panel.add(paid);

        //paid amount field
        JTextField paidfield = new JTextField();
        paidfield.setBounds(140, 370, 150, 30);
        panel.add(paidfield);

        //removal reason
        JLabel removal = new JLabel("Removal reason: ");
        removal.setBounds(20, 410, 200, 30);
        removal.setFont(font2);
        panel.add(removal);

        //removal field
        JTextField removalfield = new JTextField();
        removalfield.setBounds(160, 415, 150, 30);
        panel.add(removalfield);

        //personal trainer
        JLabel trainer = new JLabel("Personal Trainer: ");
        trainer.setBounds(20, 455, 200, 30);
        trainer.setFont(font2);
        panel.add(trainer);

        //personal trainer field
        JTextField trainerfield = new JTextField();
        trainerfield.setBounds(160, 460, 150, 30);
        panel.add(trainerfield);

        //Discount amount
        JLabel Discount = new JLabel("Discount: ");
        Discount.setBounds(20, 500, 200, 30);
        Discount.setFont(font2);
        panel.add(Discount);

        //payment field
        JTextField discountfield = new JTextField();
        discountfield.setBounds(110, 505, 150, 30);
        discountfield.setEditable(false);
        panel.add(discountfield);

        //gender
        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(350, 420, 100, 30);
        gender.setFont(font2);
        panel.add(gender);

        //gender radio button
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(450, 420, 100, 30);
        male.setFont(font2);
        panel.add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(550, 420, 100, 30);
        female.setFont(font2);
        panel.add(female);


        //to make onlyu one clickable
        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(male);
        sexGroup.add(female);
        // male.setBackground(Color.GRAY);
        // female.setBackground(Color.GRAY);

        //plan
        JLabel plan = new JLabel("Plan: ");
        plan.setBounds(350, 460, 100, 30);
        plan.setFont(font2);
        panel.add(plan);

        //combobox
        //plan
        String[] plans = {"Basic", "Standard", "Deluxe"};
        JComboBox<String> planfield = new JComboBox<>(plans);
        planfield.setBounds(400, 460, 150, 30);
        panel.add(planfield);
        pannel2.setLayout(new GridLayout(2, 1, 10, 15));

        // Create and set the regular plan price field
        JLabel regularPlanPriceLabel = new JLabel("Regular Plan Price:");
        regularPlanPriceLabel.setBounds(340, 325, 150, 25);
        regularPlanPriceLabel.setFont(font2);
        JTextField regularPlanPriceField = new JTextField("6500");
        regularPlanPriceField.setBounds(500, 325, 100, 25);
        regularPlanPriceField.setEditable(false);
        panel.add(regularPlanPriceLabel);
        panel.add(regularPlanPriceField);

       // automatically setting the price of the plan that user selected
       planfield.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String selectedPlan = planfield.getSelectedItem().toString();
               if (selectedPlan.equals("Basic")) {
                   regularPlanPriceField.setText("6500");
               } else if (selectedPlan.equals("Standard")) {
                   regularPlanPriceField.setText("12500");
               } else if (selectedPlan.equals("Deluxe")) {
                   regularPlanPriceField.setText("18500");
               } else {
                   regularPlanPriceField.setText("");
               }
           }
       });

        //buttons
        JButton regularMemberButton = new JButton("Add Regular Member");
        JButton premiumMemberButton = new JButton("Add Premium Member");
        JButton activateMembership = new JButton("Activate Membership");
        JButton button4 = new JButton("Deactivate Membership");
        JButton button5 = new JButton("Upgrade plan");
        JButton button6 = new JButton("Pay due amount");
        JButton button7 = new JButton("Mark attendence");
        JButton button11 = new JButton("Calculate Discount");
        JButton button8 = new JButton("Save to files");
        JButton button9 = new JButton("Clear all");
        JButton button10 = new JButton("Display Members");
        JButton button12 = new JButton("Revert Regularmember");
        JButton button13 = new JButton("Revert PremiumMember");
        JButton button14 = new JButton("Read from files");


        // Panel for the first row
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 90, 5));
        topPanel.add(regularMemberButton);
        topPanel.add(premiumMemberButton);
        topPanel.add(activateMembership);
        topPanel.add(button4);
        topPanel.add(button12);
        topPanel.add(button13);
    

        // Panel for the second row
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 10));
        bottomPanel.add(button6);
        bottomPanel.add(button7);
        bottomPanel.add(button8);
        bottomPanel.add(button9);
        bottomPanel.add(button10);
        bottomPanel.add(button11);
        bottomPanel.add(button5);
        bottomPanel.add(button14);
        
        //bordering the buttons
        regularMemberButton.setBorder(new EmptyBorder(10, 15, 10, 15)); 
        premiumMemberButton.setBorder(new EmptyBorder(10, 15, 10, 15));
        activateMembership.setBorder(new EmptyBorder(10, 15, 10, 15));
        button4.setBorder(new EmptyBorder(10, 15, 10, 15)); 
        button5.setBorder(new EmptyBorder(10, 15, 10, 15));
        button6.setBorder(new EmptyBorder(10, 15, 10, 15));
        button7.setBorder(new EmptyBorder(10, 15, 10, 15)); 
        button8.setBorder(new EmptyBorder(10, 15, 10, 15));
        button9.setBorder(new EmptyBorder(10, 15, 10, 15));
        button10.setBorder(new EmptyBorder(10, 15, 10, 15));
        button11.setBorder(new EmptyBorder(10, 15, 10, 15));
        button12.setBorder(new EmptyBorder(10, 15, 10, 15));
        button13.setBorder(new EmptyBorder(10, 15, 10, 15));
        button14.setBorder(new EmptyBorder(10, 15, 10, 15));

        // Add both panels to pannel2
        pannel2.add(topPanel);
        pannel2.add(bottomPanel);

        //showing info pannel
        JPanel pannel3 = new JPanel();
        pannel3.setBounds(800, 80, 700, 550);
        pannel3.setBackground(Color.LIGHT_GRAY);
        pannel3.setFont(new Font("Monospaced", Font.PLAIN, 16));
        pannel3.setLayout(null);
        frame.add(pannel3);

        JTextArea displayArea = new JTextArea();
        displayArea.setBounds(10,10,680,550);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        pannel3.add(displayArea);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(10,10,680,530);
        pannel3.add(scrollPane);

        /**
         * Action listener for Add Regular Member button
         * Validates input fields and creates a new regular member
         */
        regularMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;// Checking for the validity of the ID field
                try {
                    id = Integer.parseInt(idfield.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String name = namefield.getText();
                String location = locationfield.getText();
                String phone = phonefield.getText();
                // Checking for the valid phone number
                if (!phone.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid phone number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String email = emailfield.getText();
                // Checking for the valid email address
                if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address.", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String gender = "not selected";
                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected()) {
                    gender = "Female";
                }
                String dob = yearCombo.getSelectedItem().toString() + "-"
                + monthCombo1.getSelectedItem().toString() + "-"
                + dayCombo1.getSelectedItem().toString();
                String membershipStartDate = yearCombo1.getSelectedItem().toString() + "-"
                + monthCombo1.getSelectedItem().toString() + "-"
                + dayCombo1.getSelectedItem().toString();
                String referral = sourcefield.getText();
                
                // Checking for empty fields
                if (String.valueOf(id).isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty()
                || email.isEmpty() || gender.equals("not selected") || dob.equals("YY-MM-DD")
                || membershipStartDate.equals("YY-MM-DD") || referral.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all the fields.", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Checking for if there is repetation of the ID
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        JOptionPane.showMessageDialog(frame, "ID already exists. Please enter a different ID.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // adding the member to the arraylist
                RegularMember newMember = new RegularMember(id, name, location, phone, email, gender, dob, membershipStartDate, referral, planfield.getSelectedItem().toString());
                members.add(newMember);
                
                JOptionPane.showMessageDialog(frame, "Regular Member added successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        /**
         * Action listener for Add Premium Member button
         * Validates input fields and creates a new premium member
         */
        premiumMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                // Checking for the validity of the ID field
                try {
                    id = Integer.parseInt(idfield.getText());
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String name = namefield.getText();
                String location = locationfield.getText();
                String phone = phonefield.getText();
                // Checking for the valid phone number
                if (!phone.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid phone number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String email = emailfield.getText();
                // Checking for the valid email address
                if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address.", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String gender = "not selected";
                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected()) {
                    gender = "Female";
                }
                String dob = yearCombo.getSelectedItem().toString() + "-"
                        + monthCombo1.getSelectedItem().toString() + "-"
                        + dayCombo1.getSelectedItem().toString();
                        String membershipStartDate = yearCombo1.getSelectedItem().toString() + "-"
                        + monthCombo1.getSelectedItem().toString() + "-"
                        + dayCombo1.getSelectedItem().toString();
                        String trainer = trainerfield.getText();
                        
                        // Checking for empty fields
                        if (String.valueOf(id).isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty()
                        || email.isEmpty() || gender.equals("not selected") || dob.equals("YY-MM-DD")
                        || membershipStartDate.equals("YY-MM-DD") || trainer.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please fill all the fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        // Checking for if there is repetation of the ID
                        for (GymMember member : members) {
                            if (member.getId() == id) {
                                JOptionPane.showMessageDialog(frame, "ID already exists. Please enter a different ID.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // adding the member to the arraylist
                PremiumMember newMember = new PremiumMember(id, name, location, phone, email, gender, dob,
                membershipStartDate, trainer);
                members.add(newMember);
                
                JOptionPane.showMessageDialog(frame, "Premium Member added successfully.", "Success",
                JOptionPane.INFORMATION_MESSAGE);
            }
        });

        /**
         * Action listener for Activate Membership button
         * Activates membership for the member with given ID
         */
        activateMembership.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = idfield.getText().isEmpty() ? 0 : Integer.parseInt(idfield.getText());
                try{
                id = Integer.parseInt(idfield.getText());
            }catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

                // Check if the ID exists
                for (GymMember member : members) {
                    if (member.getId() == id) {
                       member.activateMembership();
                       JOptionPane.showMessageDialog(frame, "Membership activated successfully!", "success", JOptionPane.INFORMATION_MESSAGE);
                }     
            }
            }
        });

        /**
         * Action listener for Deactivate Membership button
         * Deactivates membership for the member with given ID
         */
         
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                try{
                id = Integer.parseInt(idfield.getText());
            }catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } 

            //checking for empty fields
            if(String.valueOf(id).isEmpty())
                {
                    JOptionPane.showMessageDialog(frame, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            // Check if the ID exists
            for (GymMember member : members) {
                if (member.getId() == id) {
                    member.deactivateMembership();
                    JOptionPane.showMessageDialog(frame, "Membership deactivated successfully!", "success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            }
            
        });

        /**
         * Action listener for Upgrade Plan button
         * Upgrades the membership plan for the member with given ID
         */
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
        
                // Validate ID input
                try {
                    id = Integer.parseInt(idfield.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                String plan = planfield.getSelectedItem().toString();
        
                // Check for empty fields
                if (plan.equals("Select") || idfield.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill the ID field and select a valid plan.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                // Check if ID exists and handle upgrade
                boolean idFound = false;
        
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        idFound = true;
        
                        if (!member.isActiveStatus()) {
                            JOptionPane.showMessageDialog(frame, "Membership is not active. Please activate the membership first.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
        
                        if (member instanceof RegularMember) {
                            RegularMember regularMember = (RegularMember) member;
                            String result = regularMember.upgradePlan(plan);
        
                            switch (result) {
                                case "Not eligible for upgrade.":
                                case "Same plan selected.":
                                case "Invalid plan.":
                                    JOptionPane.showMessageDialog(frame, result, "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(frame, result, "Success", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "This member is not a Regular Member.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        return; // Stop loop after handling the member
                    }
                }
        
                // If no member matched the ID
                if (!idFound) {
                    JOptionPane.showMessageDialog(frame, "ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        /**
         * Action listener for Calculate Discount button
         * Calculates the discount for the premium member with given ID
         */
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idfield.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (String.valueOf(id).isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill the id field.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean idFound = false;
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        idFound = true;
                        if (member instanceof PremiumMember) {
                            ((PremiumMember) member).calculateDiscount();
                            discountfield.setText(String.valueOf(((PremiumMember) member).getDiscountAmount()));
                            JOptionPane.showMessageDialog(frame, "Discount calculated successfully.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        } else {
                            JOptionPane.showMessageDialog(frame, "This member is not a Premium Member.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
                if (!idFound) {
                    JOptionPane.showMessageDialog(frame, "ID not found. Please enter a valid ID.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
         * Action listener for Clear button
         * Resets all input fields to default values
         */
        button9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");
                idfield.setText("");
                namefield.setText("");
                locationfield.setText("");
                phonefield.setText("");
                emailfield.setText("");
                male.setSelected(false);
                female.setSelected(false);
                planfield.setSelectedIndex(0);
                yearCombo.setSelectedIndex(0);
                monthCombo.setSelectedIndex(0);
                dayCombo.setSelectedIndex(0);
                yearCombo1.setSelectedIndex(0);
                monthCombo1.setSelectedIndex(0);
                dayCombo1.setSelectedIndex(0);
                sourcefield.setText("");
                paidfield.setText("");
                removalfield.setText("");
                trainerfield.setText("");
                // regularfield.setText("");
                // premiumField.setText("");
                // discountField.setText("");
        }
        });

        // i got multiple action listeners so i removed them through this
        for (ActionListener al : button5.getActionListeners()) {
            button5.removeActionListener(al);
        }

        // upgrading plan
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
        
                // Validate ID input
                try {
                    id = Integer.parseInt(idfield.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                String plan = planfield.getSelectedItem().toString();
        
                // Check for empty fields or unselected plan
                if (plan.equals("Select") || idfield.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill the ID field and select a valid plan.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                boolean idFound = false;
        
                //common id 
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        idFound = true;
        
                        if (!member.isActiveStatus()) {
                            JOptionPane.showMessageDialog(frame,
                                    "Membership is not active. Please activate the membership first.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
        
                        if (member instanceof RegularMember) {
                            RegularMember regularMember = (RegularMember) member;
                            String result = regularMember.upgradePlan(plan);
        
                            switch (result) {
                                case "Not eligible for upgrade.":
                                case "Same plan selected.":
                                case "Invalid plan.":
                                    JOptionPane.showMessageDialog(frame, result, "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(frame, result, "Success", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "This member is not a Regular Member.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        return; // exit after processing the matching member
                    }
                }
        
                // no same id found
                if (!idFound) {
                    JOptionPane.showMessageDialog(frame, "ID not found. Please enter a valid ID.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        /**
         * Action listener for Revert Regular Member button
         * Reverts the membership of a regular member
         */
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                // Checking for the validity of the ID field
                try {
                    id = Integer.parseInt(idfield.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String removalReason = removalfield.getText();

                // Checking for empty fields
                if (String.valueOf(id).isEmpty() || removalReason.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill the id field and enter a removal reason.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Checking if ID exists or not
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        if (member instanceof RegularMember) {
                            ((RegularMember) member).revertRegularMember(removalfield.getText());
                            JOptionPane.showMessageDialog(frame, "Membership reverted successfully.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    if(!idfield.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(frame, "ID not found. Please enter a valid ID.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        });

        /**
         * Action listener for Revert Premium Member button
         * Reverts the membership of a premium member
         */
        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                // Checking for the validity of the ID field
                try {
                    id = Integer.parseInt(idfield.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Checking for empty fields
                if (String.valueOf(id).isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill the id field and enter a removal reason.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Checking if ID exists or not
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        if (member instanceof PremiumMember) {
                            ((PremiumMember) member).revertPremiumMember();
                            JOptionPane.showMessageDialog(frame, "Membership reverted successfully.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "ID not found. Please enter a valid ID.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
         * Action listener for Mark Attendance button
         * Records attendance for the member with given ID
         */
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
        
                //id validation
                try {
                    id = Integer.parseInt(idfield.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                //if id fileds is empty or not
                if (idfield.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter the ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                // check if the member is active or not
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        if (member.isActiveStatus()) {
                            member.markAttendance();
                            JOptionPane.showMessageDialog(frame, "Attendance marked successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Member is inactive. Cannot mark attendance.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        return;
                    }
                }

                JOptionPane.showMessageDialog(frame, "ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        

        /**
         * Action listener for Save to Files button
         * Persists member data to files with error handling
         */
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File memberDetails = new File("members.txt");
                FileWriter writer = null;
                try {
                    if (memberDetails.createNewFile()) {
                        System.out.println("File has been created");
                    } else {
                        System.out.println("File already exists");
                    }
        
                    writer = new FileWriter(memberDetails);
                    writer.write(new String(new char[250]).replace('\0', '-') + "\n"); // First separator
        
                    // Write Header
                    writer.write(String.format(
                        "|%-5s | %-20s | %-25s | %-10s | %-25s | %-8s | %-20s | %-20s | %-10s | %-15s | %-15s | %-30s | %-50s | %-20s | %-20s | %-20s |\n",
                        "Id",
                        "Name",
                        "Location",
                        "Phone",
                        "Email",
                        "Gender",
                        "DOB",
                        "Membership Start Date",
                        "Attendance",
                        "Loyalty Points",
                        "Active Status",
                        "Plan",
                        "Referral Source",
                        "Personal Trainer",
                        "Paid Amount",
                        "Discount Amount"));
        
                    writer.write(new String(new char[250]).replace('\0', '-') + "\n"); // Second separator
        
                    for (GymMember member : members) {
                        if (member instanceof RegularMember) {
                            RegularMember tb = (RegularMember) member;
                            writer.write(String.format(
                                "|%-5s | %-20s | %-25s | %-10s | %-25s | %-8s | %-20s | %-20s | %-10s | %-15s | %-15s | %-30s | %-50s | %-20s | %-20s | %-20s |\n",
                                tb.getId(),
                                tb.getName(),
                                tb.getLocation(),
                                tb.getPhone(),
                                tb.getEmail(),
                                tb.getGender(),
                                tb.getDOB(),
                                tb.getMembershipStartDate(),
                                tb.getAttendance(),
                                tb.getLoyaltyPoints(),
                                tb.isActiveStatus() ? "Active" : "Inactive",
                                tb.getPlan(),
                                tb.getReferralSource(),
                                "-",
                                "-",
                                "-",
                                "-"));
                        } else if (member instanceof PremiumMember) {
                            PremiumMember pm = (PremiumMember) member;
                            pm.calculateDiscount();
                            writer.write(String.format(
                                "|%-5s | %-20s | %-25s | %-10s | %-25s | %-8s | %-20s | %-20s | %-10s | %-15s | %-15s | %-30s | %-50s | %-20s | %-20s | %-20s |\n",
                                pm.getId(),
                                pm.getName(),
                                pm.getLocation(),
                                pm.getPhone(),
                                pm.getEmail(),
                                pm.getGender(),
                                pm.getDOB(),
                                pm.getMembershipStartDate(),
                                pm.getAttendance(),
                                pm.getLoyaltyPoints(),
                                pm.isActiveStatus() ? "Active" : "Inactive",
                                "-",
                                "-",
                                pm.getPersonalTrainer(),
                                pm.getPaidAmount(),
                                pm.getDiscountAmount()));
                        }
                    }
        
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Data saved to file successfully.", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving data to file.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        

        /**
         * Action listener for Display Members button
         * Displays all members in a text area
         */
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder displayText = new StringBuilder();
                try {
                    displayText.append("+");
                    for (int i = 0; i < 236; i++) displayText.append("-");
                    displayText.append("+").append("\n");
                    displayText.append(String.format(
                        "| %-5s | %-20s | %-15s | %-13s | %-25s | %-8s | %-15s | %-18s | %-10s | %-10s | %-8s | %-10s | %-15s | %-10s | %-10s |\n",
                        "ID", "Name", "Location", "Phone", "Email", "Gender", "DOB", "Membership Date",
                        "Attendance", "Loyalty", "Active", "Plan", "Trainer", "Paid", "Discount"));
        
                    displayText.append("+");
                    for (int i = 0; i < 236; i++) displayText.append("-");
                    displayText.append("+").append("\n");
        
                    for (GymMember member : members) {
                        displayText.append(String.format(
                            "| %-5s | %-20s | %-15s | %-13s | %-25s | %-8s | %-15s | %-18s | %-10s | %-10s | %-8s | %-10s | %-15s | %-10s | %-10s |\n",
                            member.getId(), member.getName(), member.getLocation(), member.getPhone(),
                            member.getEmail(), member.getGender(), member.getDOB(), member.getMembershipStartDate(),
                            member.getAttendance(), member.getLoyaltyPoints(), member.isActiveStatus() ? "Yes" : "No",
                            (member instanceof RegularMember) ? ((RegularMember) member).getPlan() : "---",
                            (member instanceof PremiumMember) ? ((PremiumMember) member).getPersonalTrainer() : "---",
                            (member instanceof PremiumMember) ? ((PremiumMember) member).getPaidAmount() : "---",
                            (member instanceof PremiumMember) ? ((PremiumMember) member).getDiscountAmount() : "---"));
        
                        displayText.append("+");
                        for (int i = 0; i < 236; i++) displayText.append("-");
                        displayText.append("+").append("\n");
        
                        if (member instanceof RegularMember) {
                            ((RegularMember) member).display();
                        } else if (member instanceof PremiumMember) {
                            ((PremiumMember) member).display();
                        }
                    }
        
                    displayArea.setText(displayText.toString());
        
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error displaying member information ",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
        
        // pay due amount
        /**
         * Action listener for Pay Due Amount button
         * Validates input fields and processes payment for premium members
         * Checks for maximum payment limit and updates member status
         */
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idfield.getText().trim();
                String amountText = paidfield.getText().trim();
        
                if (idText.isEmpty() || amountText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in both ID and Amount fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                int id;
                double amount;
                try {
                    id = Integer.parseInt(idText);
                    amount = Double.parseDouble(amountText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                if (amount <= 0) {
                    JOptionPane.showMessageDialog(frame, "Amount must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                GymMember foundMember = null;
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        foundMember = member;
                        break;
                    }
                }
        
                if (foundMember == null) {
                    JOptionPane.showMessageDialog(frame, "ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                if (!(foundMember instanceof PremiumMember)) {
                    JOptionPane.showMessageDialog(frame, "This member is not a Premium Member.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                PremiumMember premiumMember = (PremiumMember) foundMember;
        
                
                if (premiumMember.getPaidAmount() + amount > 50000) {
                    JOptionPane.showMessageDialog(frame, "Total payment cannot exceed more than 50,000. Current paid: " + premiumMember.getPaidAmount(), "Payment Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                String result = premiumMember.payDueAmount(amount);
        
                
                if (premiumMember.isFullPayment()) {
                    premiumMember.calculateDiscount();
                }
        
                JOptionPane.showMessageDialog(frame, result, "Payment Status", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        /**
         * Action listener for Load Members button
         * Loads member data from a file and populates the members list
         */
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File memberData = new File("members.txt");
                    if (!memberData.exists()) {
                        JOptionPane.showMessageDialog(frame, "No saved member data found.", "Information",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
        
                    members.clear();
        
                    Scanner scanner = new Scanner(memberData);
                    int memberCount = 0;
                    if (scanner.hasNextLine()) {
                        scanner.nextLine();
                    }
                    if (scanner.hasNextLine()) {
                        scanner.nextLine();
                    }
                    if (scanner.hasNextLine()) {
                        scanner.nextLine();
                    }
                    // Skip the header and separator
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine().trim();
                        if (line.startsWith("-") || line.isEmpty()) {
                            continue;
                        }
                        
                        
                        if (line.contains("|")) {
                            String[] parts = line.trim().substring(1, line.length() - 1).split("\\|");
        
                            for (int i = 0; i < parts.length; i++) {
                                parts[i] = parts[i].trim();
                            }
        
                            try {
                                int id = Integer.parseInt(parts[0]);
                                String name = parts[1];
                                String location = parts[2];
                                String phone = parts[3];
                                String email = parts[4];
                                String gender = parts[5];
                                String dob = parts[6];
                                String membershipStartDate = parts[7];
                                int attendance = Integer.parseInt(parts[8]);
                                boolean activeStatus = parts[10].equalsIgnoreCase("Active");
        
                                // Check if it's a Regular or Premium Member
                                if (!parts[11].equals("-")) {
                                    // Regular Member
                                    String plan = parts[11];
                                    String referralSource = parts[12];
        
                                    RegularMember member = new RegularMember(id, name, location, phone, email,
                                            gender, dob, membershipStartDate, referralSource, plan);
        
                                    if (activeStatus) member.activateMembership();
                                    else member.deactivateMembership();
        
                                    for (int i = 0; i < attendance; i++) {
                                        member.markAttendance();
                                    }
        
                                    members.add(member);
                                    memberCount++;
                                } else {
                                    // Premium Member
                                    String trainer = parts[13];
                                    double paidAmount = parts[14].equals("-") ? 0 : Double.parseDouble(parts[14]);
        
                                    PremiumMember member = new PremiumMember(id, name, location, phone, email,
                                            gender, dob, membershipStartDate, trainer);
        
                                    if (activeStatus) member.activateMembership();
                                    else member.deactivateMembership();
        
                                    for (int i = 0; i < attendance; i++) {
                                        member.markAttendance();
                                    }
        
                                    if (paidAmount > 0) {
                                        member.payDueAmount(paidAmount);
                                    }
        
                                    members.add(member);
                                    memberCount++;
                                }
        
                            } catch (Exception ex) {
                                System.out.println("Error parsing member data: " + line);
                                ex.printStackTrace();
                            }
                        }
                    }
        
                    scanner.close();
        
                    if (memberCount > 0) {
                        JOptionPane.showMessageDialog(frame, memberCount + " members loaded successfully.", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "No valid member data found in file.", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
        
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error reading file: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }
}