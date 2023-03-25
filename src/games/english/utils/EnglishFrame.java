package games.english.utils;

import games.english.English;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class EnglishFrame {

    /*

        Author: https://github.com/mertks00

    */

    public static JFrame frame = new JFrame("LangGame");
    public static JLabel time = new JLabel("SÜRE: 180");

    public static JLabel dogru = new JLabel("DOĞRU: ");
    public static JLabel yanlis = new JLabel("YANLIŞ: ");


    public static void getOpenPanel() throws IOException {

        HashMap<String,String> words = new HashMap<>();

        words.put("işiniz nedir", "What 's your job");
        words.put("nasılsınız", "How are you");
        words.put("kaç yaşındasın","How old are you");
        words.put("nerelisin","Where are you from");
        words.put("nerede yaşıyorsun","Where do you live");
        words.put("bir" ,"One");
        words.put("iki","Two");
        words.put("üç","Three");
        words.put("dört","Four");
        words.put("beş","Five");
        words.put("altı", "Six");
        words.put("yedi", "Seven");
        words.put("sekiz" ,"Eight");
        words.put("dokuz","Nine");
        words.put("on","Teen");
        words.put("on bir","Eleven");
        words.put("on iki","Twelve");
        words.put("on üç", "Thirteen");
        words.put("on dört", "Fourteen");
        words.put("on beş", "Fifteen");
        words.put("on altı" ,"Sixteen");
        words.put("on yedi","Seventeen");
        words.put("on sekiz","Eighteen");
        words.put("on dokuz","Nineteen");
        words.put("yirmi","Twenty");
        words.put("sen","You");
        words.put("selam","Hi");
        words.put("biz" ,"We");
        words.put("merhaba","Hello");
        words.put("ülke","Country");
        words.put("bizim","Our");
        words.put("ben","I");
        words.put("onlar" ,"They");
        words.put("kuzen","Cousin");
        words.put("baba","Father");
        words.put("anne","Mother");
        words.put("kız kardeş","Sister");
        words.put("erkek kardeş", "Brother");
        words.put("ebeveynler", "Parents");
        words.put("hala" ,"Aunt");
        words.put("dil","Language");
        words.put("hayvan","Pet");
        words.put("ders","Subject");
        words.put("hobi","Hobby");
        words.put("favori", "Favorite");
        words.put("amca", "Uncle");
        words.put("onların","Their");
        words.put("senin","Your");
        words.put("onun","His");
        words.put("one","Her");
        words.put("benim","My");
        words.put("öğretmen", "Teacher");
        words.put("doktor" ,"Doctor");
        words.put("fırıncı","Baker");
        words.put("manav","Greengrocer");
        words.put("eczacı","Pharmacist");
        words.put("tamirci","Mechanic");
        words.put("avukat", "Lawyer");
        words.put("inşaatçı", "Builder");
        words.put("türkiye", "Turkey");
        words.put("brezilya" ,"Brazil");
        words.put("ispanya","Spain");
        words.put("çin","China");
        words.put("italya","Italy");
        words.put("fransa","France");
        words.put("yunanistan", "Greece");
        words.put("almanya", "Germany");

        ImageIcon icon = new ImageIcon("res/englishIcon.png");
        frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("res/englishBackground.jpg")))));
        frame.setIconImage(icon.getImage());

        final String[] soru = {(String) words.values().toArray()[new Random().nextInt(words.values().toArray().length)]};

        JLabel label = new JLabel();
        label.setText(soru[0]);
        label.setForeground(Color.CYAN);
        label.setFont(new Font("Calibre", Font.BOLD, 84));
        label.setBounds(10,-320,960,960);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        JTextField textField = new JTextField();
        textField.setBounds(250,320,480,50);
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setFont(new Font("Calibre",Font.BOLD, 28));

        JButton button = new JButton("Enter");
        button.setBounds(370,400,240,50);
        button.setFont(new Font("Calibre",Font.BOLD, 28));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.GRAY);

        dogru.setForeground(Color.BLACK);
        dogru.setFont(new Font("Calibre", Font.BOLD, 42));
        dogru.setBounds(720,-450,960,960);

        yanlis.setForeground(Color.BLACK);
        yanlis.setFont(new Font("Calibre", Font.BOLD, 42));
        yanlis.setBounds(720,-400,960,960);

        time.setForeground(Color.BLACK);
        time.setFont(new Font("Calibre", Font.BOLD, 42));
        time.setBounds(10,-450,960,960);

        frame.add(time);
        frame.add(dogru);
        frame.add(yanlis);
        frame.add(button);
        frame.add(label);
        frame.add(textField);

        frame.setSize(1020,720);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String cevap = textField.getText();

                if(soru[0].equalsIgnoreCase(words.getOrDefault(cevap.trim().toLowerCase(), ""))) {
                    EnglishPoint.addPoint();
                } else {
                    EnglishPoint.removePoint();
                }
                soru[0] = (String) words.values().toArray()[new Random().nextInt(words.values().toArray().length)];
                label.setText(soru[0]);



            }
        });

    }

}
