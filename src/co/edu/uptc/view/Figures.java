package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Figures  extends JPanel {
    private JLabel figure1;
    private JLabel figure2;
    private JLabel figure3;
    public Figures() {
        this.figure1 = new JLabel();
        this.figure2 = new JLabel();
        this.figure3 = new JLabel();
    }

    public void setup(){
        Random rand = new Random();
        this.setBackground(new Color(252, 214, 255));
        this.setPreferredSize(new Dimension(250,360));
        this.setLayout(null);
        ImageIcon icon = new ImageIcon("./src/imgs/apple.png");
        this.figure1.setIcon(icon);
        icon = new ImageIcon("./src/imgs/pineapple.png");
        this.figure2.setIcon(icon);

        icon = new ImageIcon("./src/imgs/avocado.png");
        this.figure3.setIcon(icon);

        this.figure1.setBounds(rand.nextInt(150),rand.nextInt(260),40,40);
        this.figure2.setBounds(rand.nextInt(150),rand.nextInt(260),40,40);
        this.figure3.setBounds(rand.nextInt(150),rand.nextInt(260),40,40);
        this.add(figure1);
        this.add(figure2);
        this.add(figure3);

        this.repaint();


    }

    public JLabel getFigure1() {
        return figure1;
    }

    public JLabel getFigure2() {
        return figure2;
    }

    public JLabel getFigure3() {
        return figure3;
    }
}
