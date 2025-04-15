package Pizzeria;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Registor {

    private JFrame frame;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JTextField txtPhone;
    private JTextField txtAddress;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	Registor window = new Registor();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Registor() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Register");
        frame.setBounds(100, 100, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.YELLOW);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblUsername.setBounds(75, 40, 75, 25);
        frame.getContentPane().add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(160, 40, 160, 25);
        frame.getContentPane().add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.YELLOW);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPassword.setBounds(75, 80, 75, 25);
        frame.getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(160, 80, 160, 25);
        frame.getContentPane().add(txtPassword);

        JLabel lblPhone = new JLabel("Phone (+371):");
        lblPhone.setForeground(Color.YELLOW);
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPhone.setBounds(50, 120, 100, 25);
        frame.getContentPane().add(lblPhone);

        txtPhone = new JTextField();
        txtPhone.setBounds(160, 120, 160, 25);
        frame.getContentPane().add(txtPhone);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setForeground(Color.YELLOW);
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAddress.setBounds(84, 160, 66, 25);
        frame.getContentPane().add(lblAddress);

        txtAddress = new JTextField();
        txtAddress.setBounds(160, 160, 160, 25);
        frame.getContentPane().add(txtAddress);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(160, 210, 100, 30);
        frame.getContentPane().add(btnRegister);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(270, 210, 80, 30);
        frame.getContentPane().add(btnBack);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(this.getClass().getResource("/Pizza poster.jpg")).getImage();
		lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 384, 361);
        frame.getContentPane().add(lblBackground);

        btnRegister.addActionListener(e -> registerUser());
        btnBack.addActionListener(e -> {
            Strart_relog.main(null);
            frame.dispose();
        });
    }

    private void registerUser() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        String phone = txtPhone.getText().trim();
        String address = txtAddress.getText().trim();

        if (username.isEmpty() || password.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Fill in all the fields!");
            return;
        }

        if (!phone.matches("\\+371\\d{8}")) {
            JOptionPane.showMessageDialog(frame, "Phone number must begin from +371 and have 8 numbers.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1 && parts[0].equals(username)) {
                    JOptionPane.showMessageDialog(frame, "This login already exists.");
                    return;
                }
            }
        } catch (IOException ignored) {}

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(username + "," + password + "," + phone + "," + address);
            writer.newLine();
            JOptionPane.showMessageDialog(frame, "successfully registered!");
            Strart_relog.main(null);
            frame.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error data saving.");
        }
    }
}

