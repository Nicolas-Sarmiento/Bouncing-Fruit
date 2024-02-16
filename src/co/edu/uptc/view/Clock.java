package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Clock extends JPanel {

    private JLabel country1;
    private JLabel country2;
    private JLabel country3;
    private JPanel container1;
    private JPanel container2;
    private JPanel container3;
    public Clock() {
        this.country1 = new JLabel("asjdfha");
        this.country2 = new JLabel("ahsdjf");
        this.country3 = new JLabel("ajdsjfha");
        this.container1 = new JPanel();
        this.container2 = new JPanel();
        this.container3 = new JPanel();
    }

    public void setup(){

        this.setPreferredSize(new Dimension(250,100));

        this.setLayout( new GridBagLayout() );
        this.setGrid();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        this.add(container1, gbc);
        gbc.gridx = 1;
        this.add(container2, gbc);
        gbc.gridx = 2;
        this.add(container3, gbc);

        this.setupTime();
    }

    public void setGrid(){

        container1.setLayout(new BorderLayout());
        container2.setLayout(new BorderLayout());
        container3.setLayout(new BorderLayout());

        container1.add(this.country1, BorderLayout.SOUTH);
        container1.add(new JLabel("Tokyo"), BorderLayout.NORTH);
        container2.add(this.country2, BorderLayout.SOUTH);
        container2.add(add(new JLabel("El Cairo")), BorderLayout.NORTH);
        container3.add(this.country3,BorderLayout.SOUTH);
        container3.add(add(new JLabel("Honolulu")), BorderLayout.NORTH);

    }

    private void setupTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.country1.setSize(new Dimension(40,20));
        new Thread( () -> {
            while ( true ){
                ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
                country1.setText(dateTime.format(formatter));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        this.country2.setSize(new Dimension(40,20));
        new Thread( () -> {

            while ( true ){
                ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of("Africa/Cairo"));
                country2.setText(dateTime.format(formatter));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        this.country3.setSize(new Dimension(40,20));
        new Thread( () -> {
            while ( true ){
                ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of("Pacific/Honolulu"));
                country3.setText(dateTime.format(formatter));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
