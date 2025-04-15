package Pizzeria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Help {

    private JFrame frame;
    private String username, phone, address;

    public static void launch(String username, String phone, String address) {
        EventQueue.invokeLater(() -> {
            try {
                Help window = new Help(username, phone, address);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Help(String username, String phone, String address) {
        this.username = username;
        this.phone = phone;
        this.address = address;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Help");
        frame.setBounds(100, 100, 400, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblHelp = new JLabel("How we can help you?");
        lblHelp.setForeground(Color.YELLOW);
        lblHelp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblHelp.setBounds(87, 10, 238, 30);
        frame.getContentPane().add(lblHelp);

        JButton btnNoPizza = new JButton("I didn't get my pizza");
        btnNoPizza.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNoPizza.setBounds(100, 60, 200, 40);
        frame.getContentPane().add(btnNoPizza);

        JButton btnProgramIssue = new JButton("Program is not working");
        btnProgramIssue.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnProgramIssue.setBounds(100, 110, 200, 40);
        frame.getContentPane().add(btnProgramIssue);

        JButton btnOther = new JButton("Other");
        btnOther.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnOther.setBounds(100, 160, 200, 40);
        frame.getContentPane().add(btnOther);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBack.setBounds(10, 270, 80, 25);
        frame.getContentPane().add(btnBack);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(this.getClass().getResource("/Pizza_poster2.jpg")).getImage();
        lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 384, 311);
        frame.getContentPane().add(lblBackground);

        btnNoPizza.addActionListener(e -> {
            Nope.launch(username, phone, address);
            frame.dispose();
        });

        btnProgramIssue.addActionListener(e -> {
        	About.launch(username, phone, address);
            frame.dispose();
        });

        btnOther.addActionListener(e -> {
        	Other.launch(username, phone, address);
            frame.dispose();
        });

        btnBack.addActionListener(e -> {
            UserWindow.launch(username, phone, address);
            frame.dispose();
        });
    }
}


