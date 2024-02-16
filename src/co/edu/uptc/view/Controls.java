package co.edu.uptc.view;

import co.edu.uptc.model.Play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controls extends JPanel implements ActionListener {
    private JButton play;
    private JButton pause;
    private JButton stop;
    private boolean status;
    private Figures panel;
    private Play runPlay1;
    private Play runPlay2;
    private Play runPlay3;

    public Controls( Figures panel) {
        this.play = new JButton("play");
        this.pause = new JButton("pause");
        this.stop = new JButton("stop");
        this.panel = panel;
        this.status = false;
        this.runPlay1 = new Play( this.panel.getFigure1());
        this.runPlay2 = new Play( this.panel.getFigure2());
        this.runPlay3 = new Play( this.panel.getFigure3());
    }

    public void setup(){
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(250,100));
        this.play.addActionListener(this);
        this.pause.addActionListener(this);
        this.stop.addActionListener(this);

        this.setLayout( new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 100, 0, 100);
        this.add(this.play, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(this.pause, gbc);
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 2;
        this.add( this.stop, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == this.play ){
          if (!status){
              new Thread( runPlay1).start();
              new Thread( runPlay2).start();
              new Thread(runPlay3).start();
              status = true;
          }else {
              runPlay1.resumeThread();
              runPlay2.resumeThread();
              runPlay3.resumeThread();
          }

        }

        if (e.getSource() == this.pause ){
            runPlay1.pauseThread();
            runPlay2.pauseThread();
            runPlay3.pauseThread();
        }

        if( e.getSource() == this.stop){
            runPlay1.stopThread();
            runPlay2.stopThread();
            runPlay3.stopThread();
        }
    }
}
