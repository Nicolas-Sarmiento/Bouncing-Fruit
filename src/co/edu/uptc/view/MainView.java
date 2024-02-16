package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private Clock clock;
    private Figures figures;
    private Controls controls;

    public MainView() {
        super();
        this.clock = new Clock();
        this.figures = new Figures();
        this.controls = new Controls(this.figures);
    }

    public void setup(){
        this.setSize( 650, 600);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.clock.setup();
        this.figures.setup();
        this.controls.setup();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        this.add(this.clock, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        this.add(this.figures,gbc);

        gbc.gridy = 2;
        this.add(this.controls,gbc);

        this.setVisible(true);
    }
}
