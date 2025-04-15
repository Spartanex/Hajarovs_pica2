package Pizzeria;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login {

    private JFrame frame;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login window = new Login();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Login() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Login");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblUsername.setForeground(Color.YELLOW);
        lblUsername.setBounds(75, 60, 75, 25);
        frame.getContentPane().add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(150, 60, 160, 25);
        frame.getContentPane().add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPassword.setForeground(Color.YELLOW);
        lblPassword.setBounds(75, 100, 75, 25);
        frame.getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 100, 160, 25);
        frame.getContentPane().add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 150, 80, 30);
        frame.getContentPane().add(btnLogin);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(240, 150, 80, 30);
        frame.getContentPane().add(btnBack);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(this.getClass().getResource("/Pizza poster.jpg")).getImage();
		lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 384, 261);
        frame.getContentPane().add(lblBackground);

        btnLogin.addActionListener(e -> loginAction());
        btnBack.addActionListener(e -> {
            Strart_relog.main(null);
            frame.dispose();
        });
    }

    private void loginAction() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equals(username) && parts[1].equals(password)) {
                    found = true;
                    String phone = parts[2];
                    String address = parts[3];
                    UserWindow.launch(username, phone, address);
                    frame.dispose();
                    break;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error user file reading.");
        }

        if (!found) {
            JOptionPane.showMessageDialog(frame, "Incorect login or password.");
        }
    }
}
