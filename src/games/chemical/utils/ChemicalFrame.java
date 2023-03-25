package games.chemical.utils;

import main.utils.Frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;

public class ChemicalFrame extends JFrame {

    /*

        Author: https://github.com/mertks00

    */

    public static JLabel time = new JLabel("SÜRE: 480");
    public static JLabel dogru = new JLabel("DOĞRU: ");
    public static JLabel yanlis = new JLabel("YANLIŞ: ");
    private JLabel questionLabel;
    private JButton answerButton1, answerButton2;
    private String[] words = {"Maddenin 4 Fiziksel hali?", "Çapraz bağlar ..... bağlardır.", "LPG sıvılaştırılmış ..... gazıdır.", "LNG sıvılaştırılmış ..... 'dır.", "Havada bulunan su buharına .... denir.", "Hidrojen bağı ..... etkileşimdir.", "... maddelerin farklı ışık dalgalarını yansıtması veya soğurmasıdır.",
                                "Periyodik tabloda ... grup vardır.", "L ... hacim birimidir.", "Bir element atomundaki proton sayısına aynı zamanda ... denir.", "Bir element atomundaki proton ve nötronların toplamı ... verir.", "HCI, HF gibi polar moleküller arasında ... etkileşimi oluşur.",
                                "... toprakta kalarak toprak kirliliğine yol açar.", "Sularda bulunan kromat ve siyanür ... olarak etki eder.", "Demir metalinde demir atomlarını tutan ... bağıdır."
    };
    private String[] translations = {"Katı, Sıvı, Gaz, Plazma.", "birincil", "petrol", "doğalgaz", "nem", "zayıf", "Ayrışma", "18", "litre", "atom numarası", "kütle numarası","dipol-dipol", "plastikler", "toksik", "metal"};
    private Random random;

    public ChemicalFrame() throws IOException {
        super("Kimya Oyunu :)");
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("res/ChemicalBackground.jpg")))));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1020, 720);
        setLocationRelativeTo(null);
        setLayout(null);

        ImageIcon icon = new ImageIcon("res/chemicalIcon.png");
        setIconImage(icon.getImage());

        random = new Random();

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Montserrat", Font.BOLD, 32));
        questionLabel.setForeground(Color.BLACK);
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setVerticalAlignment(JLabel.CENTER);
        questionLabel.setBounds(-25,-100,1020,720);
        add(questionLabel);

        answerButton1 = new JButton();
        answerButton1.addActionListener(e -> checkAnswer(answerButton1));
        answerButton1.setFont(new Font("Arial", Font.PLAIN, 26));
        answerButton1.setForeground(Color.CYAN);
        answerButton1.setBackground(Color.WHITE);
        answerButton1.setBounds(80,420,350,110);
        add(answerButton1);

        answerButton2 = new JButton();
        answerButton2.addActionListener(e -> checkAnswer(answerButton2));
        answerButton2.setFont(new Font("Arial", Font.PLAIN, 26));
        answerButton2.setForeground(Color.CYAN);
        answerButton2.setBackground(Color.WHITE);
        answerButton2.setBounds(540,420,350,110);
        add(answerButton2);

   /*     JButton finish = new JButton();
        finish.setText("Bitir!");
        finish.setFont(new Font("Arial", Font.PLAIN, 26));
        finish.setForeground(Color.BLACK);
        finish.setBackground(Color.WHITE);
        finish.setBounds(15,60,150,30);
        add(finish);

        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Frames frames = new Frames();
                try {
                    frames.run();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });*/

        dogru.setForeground(Color.RED);
        dogru.setFont(new Font("Luckiest Guy", Font.BOLD, 64));
        dogru.setBounds(680,-430,960,960);
        add(dogru);

        yanlis.setForeground(Color.RED);
        yanlis.setFont(new Font("Luckiest Guy", Font.BOLD, 64));
        yanlis.setBounds(680,-360,960,960);
        add(yanlis);

        time.setForeground(Color.BLACK);
        time.setFont(new Font("Calibre", Font.BOLD, 42));
        time.setBounds(10,-450,960,960);
        add(time);

        showNextQuestion();
    }

    private void showNextQuestion() {
        int index = random.nextInt(words.length);

        questionLabel.setText(words[index]);

        if (random.nextBoolean()) {
            answerButton1.setText(translations[index]);
            answerButton2.setText(translations[random.nextInt(translations.length)]);
        } else {
            answerButton2.setText(translations[index]);
            answerButton1.setText(translations[random.nextInt(translations.length)]);
        }
    }

    private void checkAnswer(JButton button) {
        if (button.getText().equals(translations[indexOfCurrentQuestion()])) {
            JOptionPane.showMessageDialog(this, "Doğru cevap!");
            ChemicalPoint.addPoint();
        } else {
            JOptionPane.showMessageDialog(this, "Yanlış cevap!");
            ChemicalPoint.removePoint();
        }
        showNextQuestion();
    }

    private int indexOfCurrentQuestion() {
        String currentQuestion = questionLabel.getText();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(currentQuestion)) {
                return i;
            }
        }
        return -1; // Hata durumu
    }

}
