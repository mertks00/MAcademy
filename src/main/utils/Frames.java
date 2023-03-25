package main.utils;

import games.chemical.Chemical;
import games.english.English;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Frames {

    /*

        Author: https://github.com/mertks00

    */

    private JButton english, chemical;

    public void run() throws IOException {

        JFrame frame = new JFrame("Mert Akademi");

        ImageIcon icon = new ImageIcon("res/icon.png");
        frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("res/background.jpg")))));
        frame.setIconImage(icon.getImage());

        JLabel label = new JLabel();
        label.setText("OYUN TERCIHINIZ?");
        label.setFont(new Font("Calibre", Font.BOLD, 84));
        label.setBounds(10,-320,960,960);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        JLabel owner = new JLabel();
        owner.setText("YAPIMCI: MERT KARATAŞ");
        owner.setFont(new Font("Calibre", Font.BOLD, 42));
        owner.setBounds(10,120,960,960);
        owner.setHorizontalAlignment(JLabel.CENTER);
        owner.setVerticalAlignment(JLabel.CENTER);
        frame.add(owner);

        english = new JButton();
        english.setText("English");
        english.setFont(new Font("Arial", Font.PLAIN, 42));
        english.setForeground(Color.CYAN);
        english.setBackground(Color.WHITE);
        english.setBounds(80,350,350,110);
        frame.add(english);

        chemical = new JButton();
        chemical.setText("Kimya");
        chemical.setFont(new Font("Arial", Font.PLAIN, 42));
        chemical.setForeground(Color.CYAN);
        chemical.setBackground(Color.WHITE);
        chemical.setBounds(540,350,350,110);
        frame.add(chemical);

        frame.add(label);
        frame.add(english);
        frame.add(chemical);

        chemical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.dispose();
                    Chemical.gameStart();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    English.startGame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        frame.setSize(1020,720);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
