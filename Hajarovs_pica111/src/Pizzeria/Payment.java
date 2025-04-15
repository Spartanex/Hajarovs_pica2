package Pizzeria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Payment {

    private JFrame frame;
    private JTextField txtAddress, txtPhone, txtCard;
    private double totalPrice;
    private String pizzaInfo;
    private String username;
    private String phone;
    private String address;

    public static void launch(String username, String phone, String address, String pizzaInfo, double totalPrice) {
        EventQueue.invokeLater(() -> {
            try {
                Payment window = new Payment(username, phone, address, pizzaInfo, totalPrice);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Payment(String username, String phone, String address, String pizzaInfo, double totalPrice) {
        this.username = username;
        this.pizzaInfo = pizzaInfo;
        this.totalPrice = totalPrice;
        this.phone = phone;
        this.address = address;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Payment for the order");
        frame.setBounds(100, 100, 420, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblSum = new JLabel("Amount to be paid: €" + String.format("%.2f", totalPrice));
        lblSum.setForeground(Color.YELLOW);
        lblSum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
        lblSum.setBounds(110, 20, 250, 30);
        frame.getContentPane().add(lblSum);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setForeground(Color.YELLOW);
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAddress.setBounds(89, 70, 61, 25);
        frame.getContentPane().add(lblAddress);

        txtAddress = new JTextField(address != null ? address : "");
        txtAddress.setBounds(150, 70, 200, 25);
        frame.getContentPane().add(txtAddress);

        JLabel lblPhone = new JLabel("Phone number (+371):");
        lblPhone.setForeground(Color.YELLOW);
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPhone.setBounds(22, 110, 128, 25);
        frame.getContentPane().add(lblPhone);

        txtPhone = new JTextField(phone != null ? phone : "");
        txtPhone.setBounds(150, 110, 200, 25);
        frame.getContentPane().add(txtPhone);

        JLabel lblCard = new JLabel("PayCard:");
        lblCard.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCard.setForeground(Color.YELLOW);
        lblCard.setBounds(89, 150, 61, 25);
        frame.getContentPane().add(lblCard);

        txtCard = new JTextField();
        txtCard.setBounds(150, 150, 200, 25);
        frame.getContentPane().add(txtCard);

        JButton btnConfirm = new JButton("Submit");
        btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnConfirm.setBounds(183, 207, 120, 30);
        frame.getContentPane().add(btnConfirm);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBack.setBounds(10, 270, 80, 25);
        frame.getContentPane().add(btnBack);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(this.getClass().getResource("/Pizza_poster2.jpg")).getImage();
        lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 404, 311);
        frame.getContentPane().add(lblBackground);

        btnConfirm.addActionListener(e -> confirmOrder());
        btnBack.addActionListener(e -> {
            UserWindow.launch(username, phone, address);
            frame.dispose();
        });
    }

    private void confirmOrder() {
        String enteredAddress = txtAddress.getText().trim();
        String enteredPhone = txtPhone.getText().trim();
        String enteredCard = txtCard.getText().trim();

        if (enteredAddress.isEmpty() || enteredPhone.isEmpty() || enteredCard.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Fill in all fields, please.");
            return;
        }

        if (!enteredPhone.matches("\\+371\\d{8}")) {
            JOptionPane.showMessageDialog(frame, "Phone number must begin from +371 and have 8 numbers.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) {
            writer.write("User: " + username + ", Order: " + pizzaInfo + ", Amount: €" + totalPrice + ", Address: " + enteredAddress + ", Phone: " + enteredPhone);
            writer.newLine();
            JOptionPane.showMessageDialog(frame, "Order successfully placed!");

            UserWindow.launch(username, phone, address);
            frame.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving order.");
        }
    }
}



