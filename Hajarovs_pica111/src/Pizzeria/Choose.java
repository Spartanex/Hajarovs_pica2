package Pizzeria;

import javax.swing.*;
import java.awt.*;

public class Choose {

 private JFrame frame;

 public static void launch(String username, String phone, String address) {
     EventQueue.invokeLater(() -> {
         try {
             Choose window = new Choose(username, phone, address);
             window.frame.setVisible(true);
         } catch (Exception e) {
             e.printStackTrace();
         }
     });
 }

 public Choose(String username, String phone, String address) {
     initialize(username, phone, address);
 }

 private void initialize(String username, String phone, String address) {
     frame = new JFrame("Pizza choose - " + username);
     frame.setBounds(100, 100, 450, 400);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.getContentPane().setLayout(null);

     JLabel lblTitle = new JLabel("Choose pizza");
     lblTitle.setForeground(Color.YELLOW);
     lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
     lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
     lblTitle.setBounds(100, 20, 250, 30);
     frame.getContentPane().add(lblTitle);

     JList<String> pizzaList = new JList<>(new String[] {
         "Margarita - 6.99€",
         "Peperoni - 7.99€",
         "Mushroom - 7.49€",
         "Cheese - 6.49€",
         "Hawaiian - 8.49€"
     });
     pizzaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     pizzaList.setFont(new Font("Tahoma", Font.PLAIN, 14));
     JScrollPane scrollPane = new JScrollPane(pizzaList);
     scrollPane.setBounds(100, 70, 250, 150);
     frame.getContentPane().add(scrollPane);

     JButton btnNext = new JButton("Next");
     btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
     btnNext.setBounds(160, 240, 120, 30);
     frame.getContentPane().add(btnNext);

     JButton btnBack = new JButton("Back");
     btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
     btnBack.setBounds(160, 280, 120, 30);
     frame.getContentPane().add(btnBack);
     
     JLabel lblBackground = new JLabel("");
     Image Imgs = new ImageIcon(this.getClass().getResource("/Pizza_poster2.jpg")).getImage();
     lblBackground.setIcon(new ImageIcon(Imgs));
     lblBackground.setBounds(0, 0, 434, 361);
     frame.getContentPane().add(lblBackground);

     btnNext.addActionListener(e -> {
         if (pizzaList.getSelectedIndex() != -1) {
             String selectedPizza = pizzaList.getSelectedValue();
             Payment.launch(username, phone, address, selectedPizza, 0);
             frame.dispose();
         } else {
             JOptionPane.showMessageDialog(frame, "Choose pizza, please.");
         }
     });

     btnBack.addActionListener(e -> {
         OrderMenu.launch(username, phone, address);
         frame.dispose();
     });
 }
}
