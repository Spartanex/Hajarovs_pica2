package Pizzeria;

import java.awt.Image;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class About {

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void launch(String username, String phone, String address) {
        JFrame noPizza = new JFrame("Program doesn't work");
        noPizza.setBounds(100, 100, 350, 300);
        noPizza.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        noPizza.getContentPane().setLayout(null);

        JLabel lblMessage = new JLabel();
        Image img = new ImageIcon(Nope.class.getResource("/Not_my_problem!.jpg")).getImage();
        lblMessage.setIcon(new ImageIcon(img));
        lblMessage.setBounds(78, 11, 179, 148);
        noPizza.getContentPane().add(lblMessage);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBack.setBounds(130, 200, 80, 25);
        btnBack.addActionListener(e -> {
            Help.launch(username, phone, address);
            noPizza.dispose();
        });
        noPizza.getContentPane().add(btnBack);
        
        JLabel lblNewLabel = new JLabel("Dont worry, our program be working soon...");
        lblNewLabel.setForeground(Color.YELLOW);
        lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 16));
        lblNewLabel.setBounds(24, 159, 300, 43);
        noPizza.getContentPane().add(lblNewLabel);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(Nope.class.getResource("/Pizza_poster2.jpg")).getImage();
        lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 334, 261);
        noPizza.getContentPane().add(lblBackground);

        noPizza.setVisible(true);
    }
}
