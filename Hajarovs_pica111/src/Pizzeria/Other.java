package Pizzeria;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Other {
	private static JTextField textField;

    /**
     * @wbp.parser.entryPoint
     */
    public static void launch(String username, String phone, String address) {
        JFrame Yourproblem = new JFrame("Your problem");
        Yourproblem.setBounds(100, 100, 350, 300);
        Yourproblem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Yourproblem.getContentPane().setLayout(null);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBack.setBounds(64, 200, 80, 25);
        btnBack.addActionListener(e -> {
            Help.launch(username, phone, address);
            Yourproblem.dispose();
        });
        Yourproblem.getContentPane().add(btnBack);
        
        JLabel DescribeProblem = new JLabel("Please, describe your problem.");
        DescribeProblem.setForeground(Color.YELLOW);
        DescribeProblem.setFont(new Font("Tahoma", Font.BOLD, 14));
        DescribeProblem.setBounds(64, 11, 209, 14);
        Yourproblem.getContentPane().add(DescribeProblem);
        
        JLabel WillContact = new JLabel("We will contact with you later!");
        WillContact.setForeground(Color.YELLOW);
        WillContact.setFont(new Font("Tahoma", Font.BOLD, 13));
        WillContact.setBounds(64, 36, 209, 14);
        Yourproblem.getContentPane().add(WillContact);
        
        textField = new JTextField();
        textField.setBounds(10, 61, 314, 128);
        Yourproblem.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Send");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(184, 201, 89, 23);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String inputText = textField.getText().trim();
        		if (inputText.isEmpty()) {
        			
        			JOptionPane.showMessageDialog(null, "Fill the field by your message.","Empety message", JOptionPane.WARNING_MESSAGE);
        		} else {
        			JOptionPane.showMessageDialog(null, "Message sucssesfull sended!.","Sucsses", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
        
        Yourproblem.getContentPane().add(btnNewButton);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(Nope.class.getResource("/Pizza_poster2.jpg")).getImage();
        lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 334, 261);
        Yourproblem.getContentPane().add(lblBackground);

        Yourproblem.setVisible(true);
    }
}
