package Pizzeria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Profile {

    private JFrame frame;
    private JTextArea ordersArea;
    private String username, phone, address;

    public static void launch(String username, String phone, String address) {
        EventQueue.invokeLater(() -> {
            try {
                Profile window = new Profile(username, phone, address);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Profile(String username, String phone, String address) {
        this.username = username;
        this.phone = phone;
        this.address = address;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("View profile");
        frame.setBounds(100, 100, 550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblProfile = new JLabel("Your profile");
        lblProfile.setForeground(Color.YELLOW);
        lblProfile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
        lblProfile.setBounds(200, 10, 147, 30);
        frame.getContentPane().add(lblProfile);

        JTextArea profileInfo = new JTextArea();
        profileInfo.setBackground(Color.ORANGE);
        profileInfo.setForeground(Color.BLACK);
        profileInfo.setEditable(false);
        profileInfo.setFont(new Font("Monospaced", Font.BOLD, 16));
        profileInfo.setText("Name: " + username + "\n" +
                            "Address: " + address + "\n" +
                            "Phone number: " + phone);
        profileInfo.setBounds(30, 50, 470, 70);
        frame.getContentPane().add(profileInfo);

        JLabel lblOrders = new JLabel("Active orders:");
        lblOrders.setForeground(Color.YELLOW);
        lblOrders.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblOrders.setBounds(30, 130, 200, 25);
        frame.getContentPane().add(lblOrders);

        ordersArea = new JTextArea();
        ordersArea.setBackground(UIManager.getColor("Button.disabledShadow"));
        ordersArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(ordersArea);
        scrollPane.setBounds(30, 160, 470, 200);
        frame.getContentPane().add(scrollPane);

        JButton btnCancelOrders = new JButton("Cancel orders");
        btnCancelOrders.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCancelOrders.setBounds(180, 370, 180, 30);
        frame.getContentPane().add(btnCancelOrders);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBack.setBounds(20, 420, 80, 25);
        frame.getContentPane().add(btnBack);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(this.getClass().getResource("/Pizza_poster2.jpg")).getImage();
        lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 534, 461);
        frame.getContentPane().add(lblBackground);

        btnCancelOrders.addActionListener(e -> cancelOrders());
        btnBack.addActionListener(e -> {
            UserWindow.launch(username, phone, address);
            frame.dispose();
        });

        loadOrders();
    }

    private void loadOrders() {
        ordersArea.setText("");
        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            boolean foundOrder = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User: " + username)) {
                    foundOrder = true;
                }

                if (foundOrder) {
                    ordersArea.append(line + "\n");
                }

                if (line.equals("-------------------------------------")) {
                    foundOrder = false;
                }
            }

            if (ordersArea.getText().isEmpty()) {
                ordersArea.append("You have no active orders.");
            }
        } catch (IOException e) {
            ordersArea.setText("Error loading orders.");
        }
    }

    private void cancelOrders() {
        File inputFile = new File("orders.txt");
        File tempFile = new File("orders_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean isUserOrder = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User: " + username)) {
                    isUserOrder = true;
                }
                if (!isUserOrder) {
                    writer.write(line);
                    writer.newLine();
                }
                if (line.equals("-------------------------------------")) {
                    isUserOrder = false;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error canceling orders.");
            return;
        }

        if (inputFile.delete()) {
            if (tempFile.renameTo(inputFile)) {
                JOptionPane.showMessageDialog(frame, "Your orders have been successfully cancelled.");
                loadOrders();
            } else {
                JOptionPane.showMessageDialog(frame, "Failed to update order file.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Failed to update order file.");
        }
    }
}
