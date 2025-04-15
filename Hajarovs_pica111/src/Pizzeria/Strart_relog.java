package Pizzeria;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Strart_relog {

    private JFrame frmUser;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Strart_relog window = new Strart_relog();
                window.frmUser.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Strart_relog() {
        initialize();
    }

    private void initialize() {
        frmUser = new JFrame();
        frmUser.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mixax\\eclipse-workspace\\Hhajarovs_pica\\Imgs\\Pizza icon.jpg"));
        frmUser.setTitle("User");
        frmUser.setBounds(100, 100, 400, 400);
        frmUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUser.getContentPane().setLayout(null);

        JButton btnLogin = new JButton("Log in");
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnLogin.setBounds(134, 130, 115, 44);
        frmUser.getContentPane().add(btnLogin);

        JButton btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setBounds(134, 208, 115, 44);
        frmUser.getContentPane().add(btnRegister);

        JLabel lblTitle = new JLabel("Pepino Pizza");
        lblTitle.setForeground(Color.YELLOW);
        lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
        lblTitle.setBounds(92, 11, 213, 49);
        frmUser.getContentPane().add(lblTitle);

        JLabel lblPrompt = new JLabel("Log in or Reg");
        lblPrompt.setForeground(Color.YELLOW);
        lblPrompt.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPrompt.setBounds(134, 54, 115, 25);
        frmUser.getContentPane().add(lblPrompt);

        JLabel lblBackground = new JLabel("");
        Image Imgs = new ImageIcon(this.getClass().getResource("/Pizza poster.jpg")).getImage();
		lblBackground.setIcon(new ImageIcon(Imgs));
        lblBackground.setBounds(0, 0, 384, 361);
        frmUser.getContentPane().add(lblBackground);
        
        JButton button = new JButton("New button");
        button.setBounds(149, 279, 89, 23);
        frmUser.getContentPane().add(button);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login.main(null);
                frmUser.dispose();
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Registor.main(null);
                frmUser.dispose();
            }
        });
    }
}

//Test commit
