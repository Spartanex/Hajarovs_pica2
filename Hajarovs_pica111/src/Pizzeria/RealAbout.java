package Pizzeria;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class RealAbout {

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void launch(String username, String phone, String address) {
        JFrame noPizza = new JFrame("About");
        noPizza.setBounds(100, 100, 457, 440);
        noPizza.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnBack.setBounds(161, 347, 103, 43);
        btnBack.addActionListener(e -> {
            UserWindow.launch(username, phone, address);
            noPizza.dispose();
        });
        noPizza.getContentPane().setLayout(null);
        noPizza.getContentPane().add(btnBack);
        
        JTextPane txtpn = new JTextPane();
        txtpn.setText("Pizza Tower is a 2023 platform game created by the indie developer Tour De Pizza. It follows a pizza chef, Peppino Spaghetti, who must scale a tower to prevent the destruction of his pizzeria. Across 20 side-scrolling levels, the player increases their score by gathering collectibles and defeating enemies to build combos.\r\n\r\nThe five-year development was led by the pseudonymous designer McPig and programmer Sertif. Pizza Tower began as a role-playing video game with survival horror elements before evolving into a platformer inspired by Nintendo's dormant Wario Land series, to which McPig wanted to provide a spiritual successor.\r\n\r\nLink: https://img.cryptorank.io/coins/troll_face1683570287324.png\r\n\r\n(Es nezināju, ko šeit rakstīt, tāpēc vienkārši atradu kaut ko internetā un nokopēju šeit. Neuztveriet šo informāciju tik nopietni.)");
        txtpn.setEditable(false);
        txtpn.setBounds(37, 47, 368, 289);
        noPizza.getContentPane().add(txtpn);
        
        JLabel lblNewLabel = new JLabel("ABOUT US");
        lblNewLabel.setForeground(Color.YELLOW);
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 32));
        lblNewLabel.setBounds(137, 11, 159, 25);
        noPizza.getContentPane().add(lblNewLabel);
        
        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(Nope.class.getResource("/Pizza_poster2.jpg")).getImage();
        lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 441, 401);
        noPizza.getContentPane().add(lblBackground);

        noPizza.setVisible(true);
    }
}
