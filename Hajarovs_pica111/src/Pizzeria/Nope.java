package Pizzeria;

import javax.swing.*;
import java.awt.*;

public class Nope {

    /**
     * @wbp.parser.entryPoint
     */
    public static void launch(String username, String phone, String address) {
        JFrame noPizza = new JFrame("I didn't get my pizza");
        noPizza.setBounds(100, 100, 350, 300);
        noPizza.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        noPizza.getContentPane().setLayout(null);

        JLabel lblMessage = new JLabel();
        Image img = new ImageIcon(Nope.class.getResource("/Troll Pizza.png")).getImage();
        lblMessage.setIcon(new ImageIcon(img));
        lblMessage.setBounds(79, 26, 189, 163);
        noPizza.getContentPane().add(lblMessage);

        JLabel lblNewLabel = new JLabel("Nope");
        lblNewLabel.setForeground(Color.YELLOW);
        lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 16));
        lblNewLabel.setBounds(130, 11, 80, 25);
        noPizza.getContentPane().add(lblNewLabel);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBack.setBounds(130, 200, 80, 25);
        btnBack.addActionListener(e -> {
            Help.launch(username, phone, address);
            noPizza.dispose();
        });
        noPizza.getContentPane().add(btnBack);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(Nope.class.getResource("/Pizza_poster2.jpg")).getImage();
        lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 334, 261);
        noPizza.getContentPane().add(lblBackground);

        noPizza.setVisible(true);
    }
}



