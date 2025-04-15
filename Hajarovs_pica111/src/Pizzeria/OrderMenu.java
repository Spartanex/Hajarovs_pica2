package Pizzeria;

import javax.swing.*;
import java.awt.*;

public class OrderMenu {

    private JFrame frame;

    public static void launch(String username, String phone, String address) {
        EventQueue.invokeLater(() -> {
            try {
                OrderMenu window = new OrderMenu(username, phone, address);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public OrderMenu(String username, String phone, String address) {
        initialize(username, phone, address);
    }

    private void initialize(String username, String phone, String address) {
        frame = new JFrame("Create order - " + username);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Select order method");
        lblTitle.setForeground(Color.YELLOW);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(50, 30, 340, 30);
        frame.getContentPane().add(lblTitle);

        JButton btnChoosePizza = new JButton("Choose pizza");
        btnChoosePizza.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnChoosePizza.setBounds(135, 80, 160, 40);
        frame.getContentPane().add(btnChoosePizza);

        JButton btnCreatePizza = new JButton("Create pizza");
        btnCreatePizza.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCreatePizza.setBounds(135, 130, 160, 40);
        frame.getContentPane().add(btnCreatePizza);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBack.setBounds(135, 190, 160, 30);
        frame.getContentPane().add(btnBack);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(this.getClass().getResource("/Pizza_poster2.jpg")).getImage();
        lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 434, 261);
        frame.getContentPane().add(lblBackground);

        
        btnChoosePizza.addActionListener(e -> {
        	Choose.launch(username, phone, address);
            frame.dispose();
        });

        btnCreatePizza.addActionListener(e -> {
        	Create.launch(username, phone, address, "", 0.0);
            frame.dispose();
        });

        btnBack.addActionListener(e -> {
            UserWindow.launch(username, phone, address);
            frame.dispose();
        });
    }
}
