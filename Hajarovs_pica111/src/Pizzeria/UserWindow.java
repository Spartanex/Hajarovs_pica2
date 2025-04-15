package Pizzeria;

import javax.swing.*;
import java.awt.*;

public class UserWindow {

    private JFrame frame;

    public static void launch(String username, String phone, String address) {
        EventQueue.invokeLater(() -> {
            try {
                UserWindow window = new UserWindow(username, phone, address);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UserWindow(String username, String phone, String address) {
        initialize(username, phone, address);
    }

    private void initialize(String username, String phone, String address) {
        frame = new JFrame("Main menu - " + username);
        frame.setBounds(100, 100, 450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Pepino Pizza");
        lblTitle.setForeground(Color.YELLOW);
        lblTitle.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(100, 20, 250, 30);
        frame.getContentPane().add(lblTitle);

        JButton btnOrder = new JButton("Place an order");
        btnOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnOrder.setBounds(140, 70, 160, 30);
        frame.getContentPane().add(btnOrder);

        JButton btnProfile = new JButton("View profile");
        btnProfile.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnProfile.setBounds(140, 110, 160, 30);
        frame.getContentPane().add(btnProfile);

        JButton btnHelp = new JButton("Help");
        btnHelp.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnHelp.setBounds(140, 150, 160, 30);
        frame.getContentPane().add(btnHelp);

        JButton btnAbout = new JButton("About us");
        btnAbout.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAbout.setBounds(140, 190, 160, 30);
        frame.getContentPane().add(btnAbout);

        JButton btnBack = new JButton("Exit");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnBack.setBounds(140, 230, 160, 30);
        frame.getContentPane().add(btnBack);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(this.getClass().getResource("/Pizza_poster2.jpg")).getImage();
		lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 434, 311);
        frame.getContentPane().add(lblBackground);

        
        btnOrder.addActionListener(e -> {
        	OrderMenu.launch(username, phone, address);
            frame.dispose();
        });

        btnProfile.addActionListener(e -> {
        	Profile.launch(username, phone, address);
            frame.dispose();
        });

        btnHelp.addActionListener(e -> {
        	Help.launch(username, phone, address);
            frame.dispose();
        });

        btnAbout.addActionListener(e -> {
        	RealAbout.launch(username, phone, address);
            frame.dispose();
        });

        btnBack.addActionListener(e -> {
            Strart_relog.main(null);
            frame.dispose();
        });
    }
}
