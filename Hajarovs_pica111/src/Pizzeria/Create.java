package Pizzeria;

import javax.swing.*;
import java.awt.*;

public class Create {

    private JFrame frame;

    public static void launch(String username, String phone, String address, String pizzaInfo, double totalPrice) {
        EventQueue.invokeLater(() -> {
            try {
                Create window = new Create(username, phone, address);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Create(String username, String phone, String address) {
        initialize(username, phone, address);
    }

    private void initialize(String username, String phone, String address) {
        frame = new JFrame("Create own pizza - " + username);
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Create your pizza");
        lblTitle.setForeground(Color.YELLOW);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(100, 20, 300, 30);
        frame.getContentPane().add(lblTitle);

        JLabel lblSize = new JLabel("Pizza size:");
        lblSize.setForeground(Color.YELLOW);
        lblSize.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSize.setBounds(83, 70, 87, 20);
        frame.getContentPane().add(lblSize);

        JComboBox<String> sizeBox = new JComboBox<>(new String[] {"Small - 5€", "Medium - 7€", "Big - 9€"});
        sizeBox.setBackground(Color.ORANGE);
        sizeBox.setFont(new Font("Tahoma", Font.BOLD, 11));
        sizeBox.setBounds(180, 70, 200, 25);
        frame.getContentPane().add(sizeBox);

        JLabel lblToppings = new JLabel("Filling (to 5):");
        lblToppings.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblToppings.setForeground(Color.YELLOW);
        lblToppings.setBounds(50, 110, 200, 20);
        frame.getContentPane().add(lblToppings);

        JCheckBox cbCheese = new JCheckBox("Cheese (+0.50€)");
        cbCheese.setBackground(Color.ORANGE);
        cbCheese.setFont(new Font("Tahoma", Font.BOLD, 11));
        cbCheese.setBounds(50, 140, 200, 20);
        frame.getContentPane().add(cbCheese);

        JCheckBox cbTomato = new JCheckBox("Tomato sauce (+0.30€)");
        cbTomato.setFont(new Font("Tahoma", Font.BOLD, 11));
        cbTomato.setBackground(Color.ORANGE);
        cbTomato.setBounds(50, 170, 200, 20);
        frame.getContentPane().add(cbTomato);

        JCheckBox cbMushroom = new JCheckBox("Mushrooms (+0.70€)");
        cbMushroom.setFont(new Font("Tahoma", Font.BOLD, 11));
        cbMushroom.setBackground(Color.ORANGE);
        cbMushroom.setBounds(50, 200, 200, 20);
        frame.getContentPane().add(cbMushroom);

        JCheckBox cbPepperoni = new JCheckBox("Peperoni (+1.00€)");
        cbPepperoni.setFont(new Font("Tahoma", Font.BOLD, 11));
        cbPepperoni.setBackground(Color.ORANGE);
        cbPepperoni.setBounds(50, 230, 200, 20);
        frame.getContentPane().add(cbPepperoni);

        JCheckBox cbOnion = new JCheckBox("Onion (+0.40€)");
        cbOnion.setFont(new Font("Tahoma", Font.BOLD, 11));
        cbOnion.setBackground(Color.ORANGE);
        cbOnion.setBounds(50, 260, 200, 20);
        frame.getContentPane().add(cbOnion);

        JButton btnNext = new JButton("Next");
        btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNext.setBounds(170, 320, 120, 30);
        frame.getContentPane().add(btnNext);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBack.setBounds(170, 360, 120, 30);
        frame.getContentPane().add(btnBack);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(this.getClass().getResource("/Pizza_poster2.jpg")).getImage();
        lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 484, 461);
        frame.getContentPane().add(lblBackground);

        btnNext.addActionListener(e -> {
            String selectedSize = (String) sizeBox.getSelectedItem();
            double price = 0;
            if (selectedSize.contains("5")) price += 5;
            else if (selectedSize.contains("7")) price += 7;
            else if (selectedSize.contains("9")) price += 9;

            StringBuilder ingredients = new StringBuilder("Ingridients: ");

            if (cbCheese.isSelected()) {
                price += 0.5;
                ingredients.append("Cheese, ");
            }
            if (cbTomato.isSelected()) {
                price += 0.3;
                ingredients.append("Tomato sauce, ");
            }
            if (cbMushroom.isSelected()) {
                price += 0.7;
                ingredients.append("Mushrooms, ");
            }
            if (cbPepperoni.isSelected()) {
                price += 1.0;
                ingredients.append("Peperoni, ");
            }
            if (cbOnion.isSelected()) {
                price += 0.4;
                ingredients.append("Onion, ");
            }

            if (ingredients.toString().equals("Ingridients: ")) {
                JOptionPane.showMessageDialog(frame, "Choose at least one ingridient.");
                return;
            }

            String fullPizza = selectedSize + ", " + ingredients.toString();
            Payment.launch(username, phone, address, fullPizza, price);
            frame.dispose();
        });

        btnBack.addActionListener(e -> {
            OrderMenu.launch(username, phone, address);
            frame.dispose();
        });
    }
}
